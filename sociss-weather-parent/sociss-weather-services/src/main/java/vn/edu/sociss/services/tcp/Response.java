package vn.edu.sociss.services.tcp;

public class Response {
	private String data;

	public Response(String data) {
		this.data = data;
	}

	public String getString() {
		return this.data;
	}
}
