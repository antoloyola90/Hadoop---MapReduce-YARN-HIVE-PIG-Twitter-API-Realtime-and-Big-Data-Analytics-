import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class FreebaseExtractor{
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	HttpTransport httpTransport = new NetHttpTransport();
    	com.google.api.client.http.HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
    	JSONParser parser = new JSONParser();
    	String query = "[{\"limit\": 100,\"name\":null,\"adaptations\":\"Enemy Mine\",\"type\":\"/media_common/adapted_work\"}]";
    	String query = "[{\"limit\": 100,\"type\":\"/media_common/adapted_work\"}]";
    	GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
    	url.put("key", "AIzaSyD4H7khKUc8xhtYSmDinlDp8IC3UJjX48I");
    	url.put("query", query);
    	com.google.api.client.http.HttpRequest request = requestFactory.buildGetRequest(url);
    	com.google.api.client.http.HttpRequest request = requestFactory.buildGetRequest(
    			new GenericUrl("https://www.googleapis.com/freebase/v1/search?query=&indent=true&filter=(type:/media_common/adapted_work)&key=AIzaSyD4H7khKUc8xhtYSmDinlDp8IC3UJjX48I"));


    	com.google.api.client.http.HttpResponse httpResponse = request.execute();
    	System.out.println(httpResponse.parseAsString());
    	
    	
	}
    
    

}
