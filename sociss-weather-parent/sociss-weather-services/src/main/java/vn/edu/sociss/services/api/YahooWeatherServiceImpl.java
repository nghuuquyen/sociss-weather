package vn.edu.sociss.services.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.edu.sociss.models.Weather;
import vn.edu.sociss.services.https.HttpHelper;
import vn.edu.sociss.services.https.HttpResponse;
import vn.edu.sociss.services.https.SimpleHTTPHelper;

public class YahooWeatherServiceImpl implements YahooWeatherService {
	String API_URL = "https://query.yahooapis.com/v1/public/yql";
	
	public Weather getWeatherByCityName(String cityName) {
		ObjectMapper mapper = new ObjectMapper();

		String requestQuery = "q=select * from weather.forecast " + "where woeid in (select woeid from geo.places(1) "
				+ "where text='" + cityName + "')&format=json";
		HttpHelper http = new SimpleHTTPHelper();

		try {
			URI uri = new URI("https", "query.yahooapis.com", "/v1/public/yql", requestQuery, null);
			HttpResponse res = http.get(uri.toASCIIString());

			// Do parsing JSON data.
			JsonNode root = mapper.readTree(res.getBody());
			JsonNode channel = root.path("query").path("results").path("channel");
			// Here is two fields contain needed data.
			JsonNode atmosphere = channel.path("atmosphere");
			JsonNode location = channel.path("location");
			JsonNode wind = channel.path("wind");
			JsonNode condition = channel.path("item").path("condition");

			// Get Data
			final int _temp = condition.path("temp").asInt();
			final int _windSpeed = wind.path("speed").asInt();
			final int _humidity = atmosphere.path("humidity").asInt();
			final String _cityName = location.path("city").asText() + " " + location.path("conutry");
			
			
			return new Weather(_cityName, _temp, _humidity, _windSpeed);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}
}
