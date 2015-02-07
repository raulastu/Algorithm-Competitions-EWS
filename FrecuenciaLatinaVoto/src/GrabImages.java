import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GrabImages {
	static String urlString = "http://www.frecuencialatina.com/perudecide/detail_candidate/";
	int top=900;
	private void go()  throws Exception{
		
		PrintWriter pw = new PrintWriter(new File("images"));
		
		HashMap<String, String >partiesPic= new HashMap<>();
		int blankcount=0;
		for (int i = 1; i < 1000; i++) {
			String url = urlString+i;
			System.out.println(url);
			
			String h = HTMLUtil.getHTML(url);
//			<img class="elec-pic-candidato" src="" alt="" width="103" height="95">
//			try{
			
			String partyName = getPartyName(h);
			partyName = removeAccents(partyName).trim();
			String partyPic = getPartyPic(h);
			System.err.println(partyPic);
			partiesPic.put(partyName, partyPic);
			if(partyName.equals("")){
				blankcount++;
				if(blankcount==10)
					break;
				continue;
			}
			
			String s = partyName+" => "+partyPic;
			System.out.println(s);
			pw.println(s);
			pw.flush();
		}
		
		System.out.println("partiesPic.size()"+partiesPic.size());
		pw.println(partiesPic.size());
		pw.close();
		PrintWriter pw2 = new PrintWriter(new File("images_insert.txt"));
		for (String key : partiesPic.keySet()) {
			String partyPic = partiesPic.get(key);
			String s = "UPDATE party SET logo_url='"+partyPic+"' WHERE party_name='"+key+"';";
			pw2.println(s);
			pw2.flush();
			System.out.println(s);
		}
		pw2.close();
	}
	
	String getCandidatePic(String html){
		ArrayList<HashMap<String,String>> r = new  ArrayList<>();
		String pat = "<img class=\"elec-pic-candidato\" src=\"";
		Pattern p = Pattern.compile(pat);
		Matcher mat = p.matcher(html);
//		ArrayList<IO> ios = new ArrayList<IO>();
		int x=0;
		HashMap<String,String> map = new HashMap<>();
		if(mat.find()){
			int end = html.indexOf("\"", mat.start());
			String name = html.substring(mat.start()+pat.length(),end);
//			if(name.eq)
			return name;
		}
		return "";					
	}
	String getPartyPic(String html){
		String pat = "<img class=\"elec-pic-partido\" src=\"";
		Pattern p = Pattern.compile(pat);
		Matcher mat = p.matcher(html);
//		ArrayList<IO> ios = new ArrayList<IO>();
		int x=0;
		HashMap<String,String> map = new HashMap<>();
		if(mat.find()){
			System.out.println(mat.group());
			int end = html.indexOf("\"", mat.start()+pat.length());
//			System.out.println(html+end);
			String name = html.substring(mat.start()+pat.length(), end);
//			if(name.eq)
			return name;
		}
		return "";					
	}
	String getPartyName(String html){
		ArrayList<HashMap<String,String>> r = new  ArrayList<>();
		String pat = "<p>";
		Pattern p = Pattern.compile(pat);
		Matcher mat = p.matcher(html);
//		ArrayList<IO> ios = new ArrayList<IO>();
		int x=0;
		HashMap<String,String> map = new HashMap<>();
		if(mat.find()){
			int end = html.indexOf("</p>", mat.start());
			String name = html.substring(mat.start()+pat.length(),end);
			return name;
		}
		return "";					
	}
	String removeAccents(String n){
		String a =n.toUpperCase();
		a = a.replace("Ñ", "N");
		a = a.replace("Á", "A");
		a = a.replace("É", "E");
		a = a.replace("Í", "I");
		a = a.replace("Ó", "O");
		a = a.replace("Ú", "U");
		return a;
	}
	public static void main(String[] args) throws Exception{
		new GrabImages().go();
	}
}
