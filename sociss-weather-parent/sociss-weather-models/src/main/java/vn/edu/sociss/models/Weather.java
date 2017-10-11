package vn.edu.sociss.models;

public class Weather {

	private String cityName;
	private int temperature;
	private int windSpeed;

	public Weather(String cityName, int temperature, int windSpeed) {
		super();
		this.cityName = cityName;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
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
		return "City " + this.cityName + "," 
				+ "Temp: " + this.temperature + " F," 
				+ "Wind Speed: " + this.windSpeed + " Mph.";
	}
}
