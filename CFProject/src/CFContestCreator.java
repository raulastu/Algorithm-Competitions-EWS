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
	String contestNumber="261";
	
	public void start() throws Exception{
		String html = getHTML();
//		System.err.println(html);
		String table= getProblemsTable(html);
		System.err.println(table);
		String[]no=getProblemNames(table);
		fixNames(no);
		for (int i = 0; i < no.length; i++) {
			createClass("src","templateCLass",no[i]);
		}
		System.err.println();
	}
	private void createClass(String path, String templatePath, String className) throws Exception{
		Scanner sc = new Scanner(new File("src/"+templatePath));
		String rc="";
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			System.err.println(line);
			rc += line.replace("{ClassName}", className)+"\n";
		}
		String fullPath=path+"/"+className+".java";
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
		System.err.println(list);
		return rc;
	}
	
	public String getHTML(){
		URL url;
		InputStream is = null;
		DataInputStream dis;
		String line;
		String rc="";
		try {
		    url = new URL("http://codeforces.com/contest/"+contestNumber);
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
