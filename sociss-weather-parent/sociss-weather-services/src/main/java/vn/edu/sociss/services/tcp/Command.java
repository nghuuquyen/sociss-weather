package vn.edu.sociss.services.tcp;

public interface Command {
	Response execute();
	Response execute(boolean isReturnJson);
}
