package vn.edu.sociss.services.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHTTPHelper implements HttpHelper {

	public HttpResponse get(String URL) throws IOException {
		StringBuilder sb = new StringBuilder();

		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		
		conn.disconnect();
		return new HttpResponse(sb.toString(), conn.getResponseCode());
	}

}
