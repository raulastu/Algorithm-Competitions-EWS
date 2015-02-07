import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class HTMLUtil {
	public static String getHTML(String urlString) {
		URL url;
		InputStream is = null;
		BufferedReader dis;
		String line;
		String rc="";
		try {
		    url = new URL(urlString);
		    is = url.openStream();  // throws an IOException
//		    InputStreamReader isr = new InputStreamReader(is,"UTF-8");

		    int BUFFER_SIZE = 8192;

		    dis = new BufferedReader(new InputStreamReader(is,
	                "utf-8"), BUFFER_SIZE);
		    
//		    dis = new DataInputStream(new BufferedInputStream(is));
//		    dis
		    while ((line = dis.readLine()) != null) {
		    	rc+=line+'\n';
//		        System.out.println(line);
		    }
		} catch (Exception mue) {
			mue.printStackTrace();
		} 
		return rc;
	}
	
}	
