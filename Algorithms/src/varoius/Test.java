package varoius;

public class Test {
	public static void main(String[] args) {
		int a=0;
		a++;
		try {
			a/=0;
			a+=a;
			throw new Exception();
		} catch (Exception e) {
			a++;
		}finally{
			a++;
		}
		System.err.println(a);
	}
}
