import java.io.IOException;

import javax.xml.ws.http.HTTPException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ReviewScrapper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		for(int i=1800; i<=20000;i++){
			try {
			Document doc = Jsoup.connect("http://www.city-data.com/zips/"+ String.format("%05d",i) +".html").get();
			
			//System.out.println(doc.title().split(" ")[0]);
			
			Elements links = doc.select("div div div table tbody tr td div div table tbody tr td blockquote");
			
			System.out.println("i = "+ i + ", " + links.first().text());
			}
			catch(Exception e){
				
			}
		}
		
	}

}
