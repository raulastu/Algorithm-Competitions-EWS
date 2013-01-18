import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;


public class Main {
	public static void main(String[] args) {
    	System.out.println("Default Charset=" + Charset.defaultCharset());
    	String s = "Av. Ceci, 1900-1° Andar Conj. A – Tambore";
    	System.err.println(s);
    	System.setProperty("file.encoding", "Latin-1");
    	System.out.println("file.encoding=" + System.getProperty("file.encoding"));
    	System.out.println("Default Charset=" + Charset.defaultCharset());
    	System.out.println("Default Charset in Use=" + getDefaultCharSet());
	}

    private static String getDefaultCharSet() {
    	OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
    	String enc = writer.getEncoding();
    	return enc;
    	
    }
}
