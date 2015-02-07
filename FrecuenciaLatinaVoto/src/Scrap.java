import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.NodeSetData;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Scrap {

		
		public String getHTML(String urlString) {
			URL url;
			InputStream is = null;
			BufferedReader dis;
			String line;
			String rc="";
			try {
			    url = new URL(urlString);
			    is = url.openStream();  // throws an IOException
//			    InputStreamReader isr = new InputStreamReader(is,"UTF-8");

			    int BUFFER_SIZE = 8192;

			    dis = new BufferedReader(new InputStreamReader(is,
		                "utf-8"), BUFFER_SIZE);
			    
//			    dis = new DataInputStream(new BufferedInputStream(is));
//			    dis
			    while ((line = dis.readLine()) != null) {
			    	rc+=line+'\n';
	//		        System.out.println(line);
			    }
			} catch (Exception mue) {
				mue.printStackTrace();
			} 
			return rc;
		}
		
		public void insertReg() throws Exception{
			HashMap <String,Object> result=  new ObjectMapper().readValue(new File("src/regions.json"), HashMap.class);
			ArrayList ar = (ArrayList)result.get("regions");
			PrintWriter pw = new PrintWriter("regions_inserts.txt");
			PrintWriter pwCand = new PrintWriter("region_candidates_inserts.txt");
			for (int i = 0; i < ar.size(); i++) {
				HashMap<String,String> ob = (HashMap<String,String>)ar.get(i);
				String regCode = ob.get("code");
				String name = ob.get("region");
				String url = "http://www.frecuencialatina.com/elecciones/votar/tipocandidato-1"+"/regional-"+regCode;
				String s = getHTML(url);
				ArrayList<HashMap<String,String>> can = getCandidates(s);
				String regInserts = "INSERT INTO region (region_id, region_name) VALUES ('"+regCode+"','"+name.toUpperCase()+"');";
				System.out.println(regInserts);
				pw.println(regInserts);
				for (int j = 0; j < can.size(); j++) {
					HashMap<String,String> obc = can.get(j);
					String Insert = "INSERT INTO region_president_candidate (region_id, PARTY_NAME, CANDIDATE_NAME) VALUES ('"+regCode+"','"+obc.get("party")+"','"+obc.get("candidate")+"');";
					pwCand.println(Insert);
					pwCand.flush();
					System.out.println(Insert);
				}
//				System.out.println(can);
			}
			pw.close();
			pwCand.close();
		}
		
		public void insertProv() throws Exception{
			HashMap <String,Object> result=  new ObjectMapper().readValue(new File("src/data.json"), HashMap.class);
			HashMap<String, String> prov_reg = new HashMap<>();
			ArrayList provArr = (ArrayList)result.get("provinces");
		}
		
		public void insertDist() throws Exception{
//			String hmtl = getHTML("http://www.frecuencialatina.com/elecciones/votar/tipocandidato-2/regional-6/provincial-136");
			HashMap <String,Object> result=  new ObjectMapper().readValue(new File("src/data.json"), HashMap.class);
			ArrayList ar = (ArrayList)result.get("districts");
			
			HashMap<String, String> prov_reg = new HashMap<>();
			ArrayList provArr = (ArrayList)result.get("provinces");
//			System.out.println(provArr);
			
			for (int i = 0; i < provArr.size(); i++) {
				HashMap<String, String> a = (HashMap)provArr.get(i);
				prov_reg.put(a.get("code"), a.get("region_code"));
			}
			String provInserts = "";
			
			PrintWriter pwDist = new PrintWriter("distrito_inserts.txt");
			PrintWriter pwDistCandidates = new PrintWriter("distrito_candidates_inserts.txt");
			System.out.println(provArr);
			for (int i = 0; i < ar.size(); i++) {
				HashMap<String,String> ob = (HashMap<String,String>)ar.get(i);
				System.out.println(ob);
				String distCode = ob.get("code");
				String provCode = ob.get("province_code");
				String regCode = prov_reg.get(provCode);
				String district = ob.get("district");
				String url = "http://www.frecuencialatina.com/elecciones/votar/tipocandidato-3"+"/regional-"+regCode+"/provincial-"+provCode+"/distrital-"+distCode;
				String s = getHTML(url);
				if(s.equals("")){
					i--;
					continue;
				}
				ArrayList<HashMap<String,String>> can = getCandidates(s);
				String distInserts = "INSERT INTO distrito (distrito_id, distrito_name, province_id) VALUES ('"+distCode+"','"+district+"','"+provCode+"');";
				pwDist.println(distInserts);
				for (int j = 0; j < can.size(); j++) {
					HashMap<String,String> obc = can.get(j);
					String Insert = "INSERT INTO distrito_candidates (DISTRITO_ID, PARTY_NAME, CANDIDATE_NAME) VALUES ('"+distCode+"','"+obc.get("party")+"','"+obc.get("candidate")+"');";
					pwDistCandidates.println(Insert);
					pwDistCandidates.flush();
					System.out.println(Insert);
				}
				System.out.println(url);
				System.out.println("nro:"+i);
			}
//			System.out.println(result.get("districts"));
			pwDist.close();
			pwDistCandidates.close();
		}
		
		
		ArrayList<HashMap<String,String>> getCandidates(String html){
			ArrayList<HashMap<String,String>> r = new  ArrayList<>();
			String pat = "<td>";
			Pattern p = Pattern.compile(pat);
			Matcher mat = p.matcher(html);
//			ArrayList<IO> ios = new ArrayList<IO>();
			int x=0;
			HashMap<String,String> map = new HashMap<>();
			while(mat.find()){
				int end = html.indexOf("</td>", mat.start());
				String name = html.substring(mat.start()+pat.length(),end);
				if(x%2==0)
					map.put("candidate",name);
				else{
					map.put("party",name);
					r.add(map);
					map = new HashMap<>();
				}
				x++;
			}
			return r;					
		}
		
		void parseParties() throws  Exception{
			Scanner sc= new Scanner(new File("parties"));
			HashMap<String,String> hm = new HashMap<>();
			while(sc.hasNextLine()){
				hm.put(sc.nextLine(),"");
			}
			sc.close();
			
			PrintWriter pw = new PrintWriter(new File("parties_insert.txt"));
			for (String st : hm.keySet()) {
				String in = "INSERT INTO party(party_name) VALUES ('"+st+"');";
				pw.println(in);
			}
			pw.close();
		}
		
		public static void main(String[] args) throws Exception {
//			new Scrap().insertDist();
//			new Scrap().insertProv();
//			new Scrap().insertReg();
			new Scrap().parseParties();
		}
	
}
