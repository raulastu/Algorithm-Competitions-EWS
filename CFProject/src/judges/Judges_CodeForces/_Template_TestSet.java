package Judges_CodeForces;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;
import java.lang.reflect.Method;

public class _Template_TestSet {
	
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream(new File("src/Judges_CodeForces/test.txt"));
		System.setIn(in);
		int x=0;
		String className="Judges_Codeforces._Template";
		Class clazz= Class.forName("className");
		Method method = clazz.getMethod("solve");
		method.invoke(null, null);
		_Template t= new _Template();
		t.solve();
		t.solve();
		_Template.close();
//		
			
	}
	
	boolean test(int caseNumber, String input, String myOutput, String realOutput){
		if(myOutput.equals(realOutput)){
			return true;
		}
		else{
			System.err.println(caseNumber+" failed");
			System.err.println("expected: "+realOutput);
			System.err.println("received: "+myOutput);
			return false;
		}
	}
}
