package vn.edu.sociss.server;

import java.io.IOException;

public class StartTCPServer {
	public static void main(String[] args) {
		try {
			Thread t = new WeatherTCPServer(8000);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
