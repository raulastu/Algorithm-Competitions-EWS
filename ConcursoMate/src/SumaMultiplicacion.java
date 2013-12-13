import javax.swing.JOptionPane;


public class SumaMultiplicacion {
	public static void main(String[] args) {
		int a = (int)(Math.random()*20);
		int b = (int)(Math.random()*20);
		int suma = a +b;
		int mul=a*b;
		String r = a+" y "+b;
//		System.err.println(r);
		JOptionPane.showMessageDialog(null,r);
		JOptionPane.showMessageDialog(null, "la suma es "+suma+" y la multiplicacion es "+mul);
	}
}
