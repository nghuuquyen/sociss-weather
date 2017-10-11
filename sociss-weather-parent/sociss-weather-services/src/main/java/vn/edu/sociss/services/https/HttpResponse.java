package vn.edu.sociss.services.https;

public class HttpResponse {
	public HttpResponse(String body, int statusCode) {
		super();
		this.body = body;
		this.statusCode = statusCode;
	}
	
	private String body;
	private int statusCode;
	private String errorMessage;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
