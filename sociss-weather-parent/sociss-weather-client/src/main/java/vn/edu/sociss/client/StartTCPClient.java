package vn.edu.sociss.client;

import vn.edu.sociss.services.tcp.WeatherTCPService;
import vn.edu.sociss.services.tcp.WeatherTCPServiceImpl;

public class StartTCPClient {
	/**
	 * Client just using WeatherTCPService for get weather data of 
	 * city and print to console.
	 */
	public static void main(String[] args) {
		WeatherTCPService weatherService = new WeatherTCPServiceImpl();
		String weatherInfo = weatherService.getWeatherInfoByCityName("Da Nang");
		System.out.println(weatherInfo);
	}
}
