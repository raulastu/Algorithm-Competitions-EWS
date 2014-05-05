import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class CFJavaFileGenerator {
	public CFJavaFileGenerator() throws Exception {
		String resourcesPath="/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/CFProject/src/";
		ArrayList<Problem> problemsData = new CFContestWebScrapper().getProblemsFromCF(resourcesPath, 426);
		createFilesForJava(problemsData, resourcesPath);
		// watchs for changes and run changed files
		new JavaAutoCompiler(resourcesPath);
	}
	
	private void createFilesForJava(ArrayList<Problem> problems, String folderName) throws Exception{
		for (int i = 0; i<problems.size(); i++) {
			Problem problem = problems.get(i);
			String problemFileName = problem.getProblemName();
			createClass(folderName,"templateCLass", problemFileName);
			createClassRunner(folderName,
					"templateRunner",
					problem.getContestNumber()+"_"+(char)('A'+i)+"",
					problemFileName, 
					problem.getProblemTestCases());
		}
	}
	
	private void createClassRunner(String path, String templatePath, String className, String problemClassName, ArrayList<IO> inputCases) throws Exception{
		Scanner sc = new Scanner(new File("src/"+templatePath));
		String rc="";
		int casenr=0;
		String alltestCases="";
		for (IO io: inputCases) {
			String ri ="//\t\tCase "+casenr+++"\n";
			ri+= "\t\tinput=\n";
			ri+=splitIO(io.input)+";\n";
			ri+="\t\trunTest(input,\n"+splitIO(io.output)+");\n\n";
			alltestCases+=ri;
		}
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
//			System.err.println(line);
//			String className = ((char)'A'+nbr)+"";
			
			if(line.contains("{RunnerClassName}")){
				rc += line.replace("{RunnerClassName}", className)+"\n";
			}else if(line.contains("{input-run}")){
				rc += line.replace("{input-run}",alltestCases)+"\n";
			}else if(line.contains("{ProblemClassName}")){
				rc += line.replace("{ProblemClassName}", problemClassName)+"\n";
			}else{
				rc += line+"\n";
			}
		}
		String fullPath=path+"/_"+className+".java";
		PrintWriter pw = new PrintWriter(new File(fullPath));
		pw.println(rc);
		pw.close();
		System.err.println(fullPath);
		sc.close();
	}

	String splitIO(String i_or_o){
		 String [] res = i_or_o.split("\n");
		 String ri="";
		 for (int i = 0; i < res.length; i++) {
				ri+="\t\t\""+res[i]+" \"+\n";
			}
		 return ri.substring(0,ri.length()-2);
	}
	

	private void createClass(String path, String templatePath, String className) throws Exception{
		Scanner sc = new Scanner(new File("src/"+templatePath));
		String rc="";
		while(sc.hasNextLine()){
			String line = sc.nextLine();
//			System.err.println(line);
			rc += line.replace("{ProblemClassName}", className)+"\n";
		}
		String fullPath=path+"/_"+className+".java";
		PrintWriter pw = new PrintWriter(new File(fullPath));
		pw.println(rc);
		pw.close();
		System.err.println(fullPath);
		sc.close();
	}
	public static void main(String[] args) throws Exception{
		new CFJavaFileGenerator();
	}
}
