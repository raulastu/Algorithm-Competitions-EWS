import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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


public class CFContestWebScrapper {

	
	public void start() throws Exception{
		String resourcesPath="/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/CFProject/src/";
		ArrayList<Problem> problemsData = getProblemsFromCF(resourcesPath, 332);
//		createFilesForJava(problemsData, resourcesPath);
//		System.err.println(getIOTests("http://codeforces.com/contest/282/problem/A"));;
		
	}
	
	
	static public ArrayList<Problem> getProblemsFromCF(String folderName, int contestNumber) throws Exception{
		String html = getHTML("http://codeforces.com/contest/"+contestNumber);
//		System.err.println(html);
		String table= getProblemsTable(html);
//		System.err.println(table);
		String[]no=getProblemNames(table);
		fixNames(no);
		ArrayList<Problem> problems = new ArrayList<>();
		for (int i = 0; i < no.length; i++) {
			String id  = no[i].substring(0,no[i].indexOf("_"));
			String problemFileName = contestNumber+"_"+id+"_"+no[i];
			String url = "http://codeforces.com/contest/"+contestNumber+"/problem/"+id;
			System.err.println("fetching " + url);
			try{
				ArrayList<IO> l = getIOTests(url);
				problems.add(new Problem(problemFileName, id, l, contestNumber));
//				TODO create files async. not wait until all problems are scrapped
				
				CFJavaFileGenerator.createClass(folderName,"templateCLass", problemFileName);
				CFJavaFileGenerator.createClassRunner(folderName,
						"templateRunner",
						problemFileName,
						contestNumber+"_"+id+"__Tests", 
						l);
			}catch (java.net.SocketException e){
				e.printStackTrace();
			}
//			createClassRunner(folderName,"templateRunner",contestNumber+"_"+(char)('A'+i)+"", problemFileName, l);
//			createClassRunner(folderName,"templateRunner",(char)('A'+i)+"",l);
		}
		return problems;
	}
	
	static ArrayList<IO> getIOTests(String contestURL) throws Exception{
		String html = getHTML(contestURL);
//		System.err.println(html);
		//Getting Input
		String pat = "<div class=\"title\">Input</div><pre>";
		Pattern p = Pattern.compile(pat);
		Matcher mat = p.matcher(html);
		ArrayList<IO> ios = new ArrayList<IO>();
		while(mat.find()){
			int end = html.indexOf("</pre>", mat.start());
			String input = html.substring(mat.start()+pat.length(),end);
			input =  input.replace("<br />", "\n");
			
//			System.err.println("remaining "+html.substring(mat.end()));
			String htmlForOutput=html.substring(mat.end());
			String patOut = "<div class=\"title\">Output</div><pre>";
			Pattern pOut = Pattern.compile(patOut);
			Matcher matOut = pOut.matcher(htmlForOutput);
			if(matOut.find()){
				int endOut = htmlForOutput.indexOf("</pre>", matOut.start());
				String output = htmlForOutput.substring(matOut.start()+patOut.length(),endOut);
				output =  output.replace("<br />", "\n");
				ios.add(new IO(input, output));
			}
//			ios.add(new IO(input, ""));
//			System.err.println(input);
		}
		return ios;
	}
	
	static void fixNames(String[] names){
		for (int i = 0; i < names.length; i++) {
			names[i]=names[i].replace(" ", "_");
//			names[i]=names[i].replaceAll("[^A-Za-z_]", "");
			System.err.println(names[i]);
		}
	}
	
	static String getProblemsTable(String html){
		Scanner in = new Scanner(new ByteArrayInputStream(html.getBytes()));
		String rc="";
		boolean inTable=false;
		int nrtr=0;
		while(in.hasNextLine()){
			String line = in.nextLine();
			if(line.trim().contains("<table class=\"problems\">")){
				inTable=true;
			}
			if(inTable && line.trim().contains("</table>")){
				inTable=false;
				
				line = line.replaceAll("&nbsp;", " ");
				
				rc+="</tr>";
				rc+=line+"\n";
				break;
			}
			if(inTable){
				line = line.replace("&nbsp;", " ");
				if(line.contains("<tr")){
					nrtr++;
				}
				if(line.contains("<tr") && nrtr>2){
//					nrtr++;
					rc+="</tr>";
				}
				rc+=line+"\n";
			}
		}
		return rc;
	}
	public static String[] getProblemNames(String html) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(html.getBytes()));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		javax.xml.xpath.XPathExpression expr = xpath.compile("/table/tr/td/div[@style='position: relative;']/div/a");
//		XPathExpression expr = xpath.compile("/howto/topic[@name='PowerBuilder']/url");
		NodeList list = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
		String[] rc= new String[list.getLength()];
		for(int i =0; i<list.getLength();i++){
			rc[i]=list.item(i).getTextContent();
		}
		
		
//		
		
		
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		 doc = builder.parse(new ByteArrayInputStream(html.getBytes()));
		 xPathfactory = XPathFactory.newInstance();
		 xpath = xPathfactory.newXPath();
		expr = xpath.compile("/table/tr/td[@class='id']/a");
//		XPathExpression expr = xpath.compile("/howto/topic[@name='PowerBuilder']/url");
		list = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
//		String[] rc= new String[list.getLength()];
		for(int i =0; i<list.getLength();i++){
			String id = list.item(i).getTextContent();
			id = id.replace(" ","");
			id = id.replace("\n","");
			rc[i] =  id+"_"+ rc[i];
		}
//		System.err.println(list);
		return rc;
	}
	
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
	
	public static void main(String[] args) throws Exception {
		CFContestWebScrapper ob = new CFContestWebScrapper();
		ob.start();
	}
}
