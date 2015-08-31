import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;


public class Main {

	static public String getHTML(String urlString){
		URL url;
		InputStream is = null;
		DataInputStream dis;
		String line;
		String rc="";
		try {
		    url = new URL(urlString);
		    is = url.openStream();  // throws an IOException
		    dis = new DataInputStream(new BufferedInputStream(is));

		    while ((line = dis.readLine()) != null) {
		    	rc+=line+'\n';
//		        System.out.println(line);
		    }
		} catch (MalformedURLException mue) {
		     mue.printStackTrace();
		} catch (IOException ioe) {
		     ioe.printStackTrace();
		} finally {
		    try {
		        is.close();
		    } catch (IOException ioe) {
		    	ioe.printStackTrace();
		        // nothing to see here
		    }
		}
		return rc;
	}
	static String[] domains = {"com","me","tv","net","io"};
	
	public static void main(String[] args) {
		String companies = getHTML("https://api.angel.co/1/startups?filter=raising&access_token=33400c49d9f16f21f4e61f0c51b79c3f5721445902a26918");
		JSONObject obj = (JSONObject) JSONValue.parse(companies);
		JSONArray ar = (JSONArray)obj.get("startups");
		for (int i = 0; i < ar.size(); i++) {
			JSONObject company = (JSONObject)ar.get(i);
			String companyUrl = company.get("company_url").toString().replace("https://", "").replace("http://","");
			System.out.println(companyUrl);
			String companyUrlXYZ = companyUrl;
			for (int j = 0; j < domains.length; j++) {
				if(companyUrl.contains("."+domains[j])){
					companyUrlXYZ = companyUrl.replace(domains[j], "xyz");
					break;
				}
			}
			
			System.out.println(companyUrlXYZ);
			String url = "https://pe.godaddy.com/domainsapi/v1/search/exact?q="+companyUrlXYZ+"&key=dpp_search&pc&ptl";
//			System.out.println(url);
			String a = getHTML(url);
			
//			System.out.println(a);
			JSONObject cp = (JSONObject)JSONValue.parse(a);
			String isaval = ((JSONObject)cp.get("ExactMatchDomain")).get("IsAvailable").toString();
//			System.out.println(isaval);
			if(a.contains("\"IsAvailable\":true")){
				System.err.println(companyUrlXYZ);
			}
		}

		
//		System.out.println(a);
	}
}
