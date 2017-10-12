package vn.edu.sociss.services.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class WeatherTCPServiceImpl implements WeatherTCPService {

	public String getWeatherInfoByCityName(String cityName) {
		StringBuilder sb = new StringBuilder();
		DataInputStream is = null;
		DataOutputStream out = null;

		// TODO: Need find solution for avoid hard code here.
		String serverName = "127.0.0.1";
		int port = 8000;

		try {
			// Step 1. Connect to TCP server
			Socket client = new Socket(serverName, port);

			// Step 2. Write message to server, in this case it write city name
			OutputStream outToServer = client.getOutputStream();
			out = new DataOutputStream(outToServer);
			out.writeUTF("weather --city=\"" + cityName + "\"");

			// Step 3. Get response from server
			is = new DataInputStream(client.getInputStream());
			String responseLine;

			while ((responseLine = is.readUTF()) != null) {
				sb.append(responseLine);
			}

			// Step 4. Close connection
			is.close();
			client.close();
		} catch (EOFException e) {
			System.out.println("Done:: Recived all response data from server.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Return string data get from server.
		return sb.toString();
	}

}
