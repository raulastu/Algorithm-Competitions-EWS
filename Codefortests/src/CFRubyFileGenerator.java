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

public class CFRubyFileGenerator {
	public CFRubyFileGenerator() throws Exception {
		String resourcesPath = "/Users/rc/git-repos/rubyforces";
		int contestNumber = 332;
		String folderPath = resourcesPath + "/_" + contestNumber;

		 ArrayList<Problem> problemsData = new CFContestWebScrapper().getProblemsFromCF(resourcesPath, contestNumber);

		// create folder
		File file = new File(folderPath);
		System.err.println(file);
		if (file.exists()) {
			System.err.println("Folder already exists");
		} else {
			file.mkdir();
		}
		createRubyFiles(problemsData, folderPath);
		// createFilesForJava(problemsData, resourcesPath);
		// watchs for changes and run changed files

	}

	private void createRubyFiles(ArrayList<Problem> problems, String folderName)
			throws Exception {
		for (int i = 0; i < problems.size(); i++) {
			char letter = (char) ('A' + i);
			Problem problem = problems.get(i);
			String problemFileName = "_"+problem.getProblemName();
			File file = new File(folderName+"/"+letter);
			String problemfolderName=folderName+"/"+letter;
			file.mkdir();
			createRubyClass(problemfolderName,
					"/Users/rc/git-repos/rubyforces/template.rb",
					problemFileName);
			createTestCases(problemfolderName, problem.getProblemTestCases(), problemFileName);
		}
	}

	private void createTestCases(String path, ArrayList<IO> inputCases, String problemName)
			throws Exception {
		int i = 1;
		for (IO io : inputCases) {
			PrintWriter pw = new PrintWriter(new File(path + "/test_" + i
					+ ".txt"));
			pw.print(io.input);
			i++;
			pw.close();
		}
		File runfile = new File(path+"/runtests.sh");
		runfile.setExecutable(true);
		PrintWriter pw1 = new PrintWriter(runfile);
		String content = "echo \"Running test cases\"\n"+
			"for var in *.txt\n"+
			"do\n" +
				"\truby "+problemName+".rb $var\n"+
			"done\n" +
				"echo \"\nFinished test cases\"\n";
		pw1.print(content);
		pw1.close();
	}

	String splitIO(String i_or_o) {
		String[] res = i_or_o.split("\n");
		String ri = "";
		for (int i = 0; i < res.length; i++) {
			ri += "\t\t\"" + res[i] + " \"+\n";
		}
		return ri.substring(0, ri.length() - 2);
	}

	private void createRubyClass(String path, String templatePath,
			String className) throws Exception {
		Scanner sc = new Scanner(new File(templatePath));
		// className
		String rc = "";
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			// System.err.println(line);
			rc += line + "\n";
		}
		String fullPath = path + "/"+className + ".rb";
		PrintWriter pw = new PrintWriter(new File(fullPath));
		pw.println(rc);
		pw.close();
		System.err.println(fullPath);
		sc.close();
	}

	public static void main(String[] args) throws Exception {
		new CFRubyFileGenerator();
	}
}
