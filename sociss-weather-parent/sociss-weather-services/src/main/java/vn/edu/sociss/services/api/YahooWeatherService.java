package vn.edu.sociss.services.api;

import vn.edu.sociss.models.Weather;

public interface YahooWeatherService {
	Weather getWeatherByCityName(String cityName);
}
