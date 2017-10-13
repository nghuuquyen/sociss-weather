package vn.edu.sociss.services.tcp;

import vn.edu.sociss.services.exception.InvalidCommand;

public class WeatherCommandParser {
	/**
	 * Parsing given string command for get config data.
	 * 
	 * @param cmd
	 * 
	 * @return WeatherCommand
	 * @throws InvalidCommand
	 */
	static WeatherCommand parse(String cmd) throws InvalidCommand {
		int cityNameIndex = cmd.indexOf("--city=\"");
		String cityName;

		if (cityNameIndex != -1) {
			cityName = cmd.substring(cityNameIndex + 8, cmd.indexOf("\"", cityNameIndex + 8));
		} else {
			throw new InvalidCommand("Argument --city not found.");
		}

		return new WeatherCommand(cityName);
	}
}
