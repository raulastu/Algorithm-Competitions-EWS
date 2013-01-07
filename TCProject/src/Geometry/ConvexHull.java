package Geometry;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ConvexHull {

	public ConvexHull() {
		Point2D[] p = new Point2D[10];
		
		Stack<Point2D> hull = new Stack<Point2D>();
		Arrays.sort(p, Point2D.Y_ORDER);
		Arrays.sort(p, Point2D.BY_POLAR_ORDER);
		 
		hull.push(p[0]);
		hull.push(p[1]);
		int N = p.length;
		for (int i = 0; i < N; i++) {
			Point2D top = hull.pop();
			while(Point2D.isCCW(hull.peek(), top, p[i])<=0){
				top=hull.pop();
			}
			hull.push(top);
			hull.push(p[i]);
		}
	}

}

class Point2D{
	private final int x;
	private final int y;
	public Point2D(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public static int isCCW(Point2D a, Point2D b, Point2D c){
		int area2=(b.x+a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
		if(area2<0)return -1; 		//clockwise
		else if(area2>0) return +1; //counter-clockwise
		else return 0; 				//collinear
	}
	
	public static Comparator<Point2D> Y_ORDER = new Comparator<Point2D>() {
		
		@Override
		public int compare(Point2D o1, Point2D o2) {
			if(o1.y>o2.y) return 1;
			if(o1.y<o2.y) return -1;
			return 0;
		}
	};
	public static Comparator<Point2D> BY_POLAR_ORDER = new Comparator<Point2D>() {
		
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}