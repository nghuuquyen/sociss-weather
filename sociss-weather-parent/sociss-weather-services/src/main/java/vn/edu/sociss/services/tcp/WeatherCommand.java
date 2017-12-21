package vn.edu.sociss.services.tcp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.edu.sociss.models.Weather;
import vn.edu.sociss.services.api.YahooWeatherService;
import vn.edu.sociss.services.api.YahooWeatherServiceImpl;

public class WeatherCommand implements Command {
	private String cityName;

	public WeatherCommand(String cityName) {
		this.cityName = cityName;
	}

	public Response execute() {
		return execute(false);
	}

	public Response execute(boolean isReturnJson) {
		YahooWeatherService service = new YahooWeatherServiceImpl();
		Weather weather = service.getWeatherByCityName(cityName);
		String data;

		if (isReturnJson) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				data = mapper.writeValueAsString(weather);
			} catch (IOException e) {
				data = weather.toString();
			}
		} else {
			data = weather.toString();
		}

		return new Response(data);
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
