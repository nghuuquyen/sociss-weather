package vn.edu.sociss.services.https;

import java.io.IOException;
import java.net.MalformedURLException;

public interface HttpHelper {
	HttpResponse get(String URL) throws MalformedURLException, IOException;
}

