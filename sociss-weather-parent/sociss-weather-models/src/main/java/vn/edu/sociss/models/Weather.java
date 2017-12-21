package vn.edu.sociss.models;

public class Weather {
	
	private String cityName;
	private int temperature;
	private int windSpeed;
	private int humidity;

	public Weather(String cityName, int temperature,int humidity, int windSpeed) {
		super();
		this.cityName = cityName;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.humidity = humidity;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public String toString() {
		return "City: " + this.cityName + "," 
				+ "Temperature: " + this.temperature + " F," 
				+ "Wind Speed: " + this.windSpeed + " Mph,"
				+ "Humidity: " + this.humidity + "%.";
	}
}
