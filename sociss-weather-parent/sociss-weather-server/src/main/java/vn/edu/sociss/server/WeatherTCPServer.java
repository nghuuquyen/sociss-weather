package vn.edu.sociss.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import vn.edu.sociss.models.Weather;
import vn.edu.sociss.services.api.YahooWeatherService;
import vn.edu.sociss.services.api.YahooWeatherServiceImpl;

public class WeatherTCPServer extends Thread {
	private ServerSocket serverSocket;

	public WeatherTCPServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				
				// Read city name input string from client
				String cityName = in.readUTF();
				YahooWeatherService weatherService = new YahooWeatherServiceImpl();
				Weather weather = weatherService.getWeatherByCityName(cityName);
					
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF(weather.toString());
				
				out.close();
				server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
