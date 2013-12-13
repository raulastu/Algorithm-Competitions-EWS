import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Scanner;


public class Triang {
	
	private void solve() {

		
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int c=0;
		Point2D p = new Point();
//		p.
		while(c++<n){
			String [] a = in.nextLine().split(" ");
			L t1[] = {
					new L(new P(Integer.parseInt(a[0]), Integer.parseInt(a[1])),
							new P(Integer.parseInt(a[2]), Integer.parseInt(a[3])))
					,
					new L(new P(Integer.parseInt(a[2]), Integer.parseInt(a[3])),
							new P(Integer.parseInt(a[4]), Integer.parseInt(a[5])))
					,
					new L(new P(Integer.parseInt(a[4]), Integer.parseInt(a[5])),
							new P(Integer.parseInt(a[0]), Integer.parseInt(a[1])))
					,
			};
			a = in.nextLine().split(" ");
			L t2[] = {
					new L(new P(Integer.parseInt(a[0]), Integer.parseInt(a[1])),
							new P(Integer.parseInt(a[2]), Integer.parseInt(a[3])))
					,
					new L(new P(Integer.parseInt(a[2]), Integer.parseInt(a[3])),
							new P(Integer.parseInt(a[4]), Integer.parseInt(a[5])))
					,
					new L(new P(Integer.parseInt(a[4]), Integer.parseInt(a[5])),
							new P(Integer.parseInt(a[0]), Integer.parseInt(a[1])))
					,
			};
			
		}
	}
	
	boolean in(L[] t1, L[] t2){
		for (int i = 0; i < t1.length; i++) {
			for (int j = i+1; j < t1.length; j++) {
				for (int k = 0; k < t2.length; k++) {
					if( isIntersect(t1[i].a, t1[i].b, t2[k].a, t2[k].b)
							&& isIntersect(t1[j].a, t1[j].b, t2[k].a, t2[k].b))
						return true;
					
				}
			}
		}
		return false;
	}
	
	boolean in2(L[] t1, L[] t2){
		for (int i = 0; i < t1.length; i++) {
			for (int j = i+1; j < t1.length; j++) {
				for (int k = 0; k < t2.length; k++) {
					if( isIntersect(t1[i].a, t1[i].b, t2[k].a, t2[k].b)
							&& isIntersect(t1[j].a, t1[j].b, t2[k].a, t2[k].b))
						return true;
					
				}
			}
		}
		return false;
	}
	
	public Triang() {
		solve();
	}
	
	class L{
		P a; P b;
		public L(P a, P b) {
			this.a=a;
			this.b=b;
		}
		
	}
	
	class P{
		int x,y;
		
		public P(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		int lng(){
			return x;
		}
		int lat(){
			return y;
		}
	}
	boolean CCW(P p1,P p2,P p3) {
		  int a = p1.lng(), b = p1.lat(); 
		  int c = p2.lng(), d = p2.lat();
		  int e = p3.lng(), f = p3.lat();
		  return (f - b) * (c - a) > (d - b) * (e - a);
		}

	boolean isIntersect(P p1,P p2,P p3,P p4) {
	  return (CCW(p1, p3, p4) != CCW(p2, p3, p4)) && (CCW(p1, p2, p3) != CCW(p1, p2, p4));
	}
}
