package vn.edu.sociss.server;

import vn.edu.sociss.models.Weather;
import vn.edu.sociss.services.api.YahooWeatherService;
import vn.edu.sociss.services.api.YahooWeatherServiceImpl;

public class StartTCPServer {
	public static void main(String[] args) {
		YahooWeatherService weatherService = new YahooWeatherServiceImpl();
		Weather weather = weatherService.getWeatherByCityName("Ha Noi");

		System.out.println(weather);
	}
}
