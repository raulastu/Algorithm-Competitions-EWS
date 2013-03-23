import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AutoCompiler implements Runnable {

	private Map<String, Long> snapshot;

	void loadSnapshot() {
		snapshot = new HashMap<String, Long>();
		File s = new File(folder);
		for (File file : s.listFiles()) {
			if (!file.getName().endsWith(".java"))
				continue;
			String name = file.getName();
			pr(name);
			name=name.replaceAll("\\.java$", "");
			snapshot.put(name, file.lastModified());
			String xx = file.getAbsolutePath().replaceAll("\\.java$", "");
			pr(xx);
			pr(name + " loaded");
		}
	}

	void check() throws Exception {
		File s = new File(folder);
		for (File file : s.listFiles()) {
			if (!file.getName().endsWith(".java"))
				continue;
			
			long myDate = file.lastModified();
			String name = file.getName().replaceAll("\\.java$", "");
			if (snapshot.get(name) != myDate) {
//				pr(snapshot);
				String runnerName =  name.replaceAll("(^_[0-9]+_[ABCDE]).+", "$1");
				pr("runnerName",runnerName);
				boolean isRunner=false;
				if(name.matches("_[0-9]_[ABCDE]$")){
					runnerName=name;
//					System.err.println("isRunner");
					isRunner=true;
//					runnerName=name;
//					name = name.replace("_Runner", "");
				}
				if(isRunner){
					runCommand("javac -cp " + folder + " " + folder+ name + ".java");
					runCommand("java -cp " + folder + " " + name);
				}else{
					runCommand("javac -cp " + folder + " " + folder + runnerName + ".java");
					runCommand("java -cp " + folder + " " + runnerName);
				}	
				snapshot.put(name, myDate);
			}
		}
	}

	private void runCommand(String cmd) throws Exception {
		pr("running " + cmd);
		Process proc = Runtime.getRuntime().exec(cmd);
		Runtime.getRuntime().exec("java _C_runner");
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(
				proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(
				proc.getErrorStream()));

		// read the output from the command
		// System.out.println("Here is the standard output of the command:\n");
		String outs = "";
		while ((outs = stdInput.readLine()) != null) {
			System.out.println(outs);
		}

		// read any errors from the attempted command
		// System.out.println("Here is the standard error of the command (if any):\n");
		outs = "";
		while ((outs = stdError.readLine()) != null)
			System.err.println(outs);

	}

	public AutoCompiler(String folder) {
		this.folder=folder;
		t = new Thread(this);
		t.start();
	}
	
	String folder;
	Thread t;

	public void run() {
		loadSnapshot();
		while (true) {
			try {
				check();
				t.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		AutoCompiler main = new AutoCompiler("/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/CFProject/src/");
		main.loadSnapshot();
		main.check();
	}

	static void pr(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}
