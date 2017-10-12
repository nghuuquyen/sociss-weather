package vn.edu.sociss.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import vn.edu.sociss.services.exception.InvalidCommand;
import vn.edu.sociss.services.exception.NotFoundCommand;
import vn.edu.sociss.services.tcp.Command;
import vn.edu.sociss.services.tcp.CommandBuilder;

public class WeatherTCPServer extends Thread {
	private ServerSocket serverSocket;
	private int port;

	public WeatherTCPServer(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);

		// Default timeout is 15 seconds.
		serverSocket.setSoTimeout(15 * 1000);
	}

	public void run() {
		System.out.println("Server running at port " + port);
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				System.out.println("New Client " + socket.getInetAddress());
				
				new Thread(new HandleRequest(socket)).start();
			} 
			catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public class HandleRequest implements Runnable {
		Socket socket;

		public HandleRequest(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream(socket.getInputStream());

				// Read command string from client.
				String cmdString = in.readUTF();
				Command command = null;

				try {
					if (cmdString.startsWith("weather")) {
						command = CommandBuilder.getWeatherCommand(cmdString);
					} 
					else {
						throw new NotFoundCommand(cmdString + " not found.");
					}
				} catch (InvalidCommand | NotFoundCommand e) {
					out.writeUTF(e.getMessage());
					socket.close();
				}

				if(command != null) {
					out.writeUTF(command.execute().getString());
				}
				
				out.close();
				socket.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}

	}
}
