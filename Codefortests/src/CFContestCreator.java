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


public class CFContestCreator {

	
	public void start() throws Exception{
		String resourcesPath="/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/CFProject/src/";
//		createContest(resourcesPath,"284");
//		System.err.println(getIOTests("http://codeforces.com/contest/282/problem/A"));;
		new AutoCompiler(resourcesPath);
	}
	
	private void createContest(String folderName, String contestNumber) throws Exception{
		String html = getHTML("http://codeforces.com/contest/"+contestNumber);
//		System.err.println(html);
		String table= getProblemsTable(html);
//		System.err.println(table);
		String[]no=getProblemNames(table);
		fixNames(no);
		for (int i = 0; i < no.length; i++) {
			createClass(folderName,"templateCLass",(char)('A'+i)+"");
			ArrayList<IO> l = getIOTests("http://codeforces.com/contest/"+contestNumber+"/problem/"+(char)('A'+i));
			createClassRunner(folderName,"templateRunner",(char)('A'+i)+"",l);
		}
		System.err.println();
	}
	
	private ArrayList<IO> getIOTests(String contestURL) throws Exception{
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
	class IO{
		String input;
		String output;
		public IO(String input, String output) {
			this.input=input;
			this.output=output;
		}
		@Override
		public String toString() {
			return input+" "+output;
		}
	}
	
	private void createClassRunner(String path, String templatePath, String className, ArrayList<IO> inputCases) throws Exception{
		Scanner sc = new Scanner(new File("src/"+templatePath));
		String rc="";
		String alltestCases="";
		for (IO io: inputCases) {
			String ri = "\t\tinput=\n";
			String [] inputLines = io.input.split("\n");
			for (int i = 0; i < inputLines.length; i++) {
				ri+="\t\t\""+inputLines[i]+" \"+\n";
			}
			ri=ri.substring(0,ri.length()-2)+";\n";
			ri+="\t\trunTest(input,\""+io.output.substring(0,io.output.length()-1)+"\");\n";
			alltestCases+=ri;
		}
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
//			System.err.println(line);
//			String className = ((char)'A'+nbr)+"";
			
			if(line.contains("{ProblemLetter}")){
				rc += line.replace("{ProblemLetter}", className)+"\n";
			}else if(line.contains("{input-run}")){
				rc += line.replace("{input-run}",alltestCases)+"\n";
			}else{
				rc += line+"\n";
			}
		}
		String fullPath=path+"/_"+className+"_Runner.java";
		PrintWriter pw = new PrintWriter(new File(fullPath));
		pw.println(rc);
		pw.close();
		System.err.println(fullPath);
		sc.close();
	}
	
	private void createClass(String path, String templatePath, String className) throws Exception{
		Scanner sc = new Scanner(new File("src/"+templatePath));
		String rc="";
		while(sc.hasNextLine()){
			String line = sc.nextLine();
//			System.err.println(line);
			rc += line.replace("{ClassName}", className)+"\n";
		}
		String fullPath=path+"/_"+className+".java";
		PrintWriter pw = new PrintWriter(new File(fullPath));
		pw.println(rc);
		pw.close();
		System.err.println(fullPath);
		sc.close();
	}
	
	private void fixNames(String[] names){
		for (int i = 0; i < names.length; i++) {
			names[i]=names[i].replace(" ", "_");
		}
	}
	
	private String getProblemsTable(String html){
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
				line = line.replace("&nbsp;", " ");
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
	public String[] getProblemNames(String html) throws Exception{
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
			System.err.println(list.item(i).getTextContent());
		}
//		System.err.println(list);
		return rc;
	}
	
	public String getHTML(String urlString){
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
		        // nothing to see here
		    }
		}
		return rc;
	}
	public static void main(String[] args) throws Exception {
		CFContestCreator ob = new CFContestCreator();
		ob.start();
	}
}
