package vn.edu.sociss.services.tcp;

import vn.edu.sociss.services.api.YahooWeatherService;
import vn.edu.sociss.services.api.YahooWeatherServiceImpl;

public class WeatherCommand implements Command {
	private String cityName;

	public WeatherCommand(String cityName) {
		this.cityName = cityName;
	}
	
	public Response execute() {
		YahooWeatherService service = new YahooWeatherServiceImpl();
		String data = service.getWeatherByCityName(cityName).toString();
		
		return new Response(data);
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
