package vn.edu.sociss.services.tcp;

import vn.edu.sociss.services.exception.InvalidCommand;

public class CommandBuilder {

	public static WeatherCommand parseWeatherCommand(String cmd) throws InvalidCommand {
		return WeatherCommandParser.parse(cmd);
	};
}
