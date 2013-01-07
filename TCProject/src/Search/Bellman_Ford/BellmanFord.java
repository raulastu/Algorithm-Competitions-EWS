package Search.Bellman_Ford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//shortest path in a graph with even negatives weights.
//Warning; negative cycles may appear and this algorithm may not solve it but it can detect it.
public class BellmanFord {
	
	
	static class Vertex {
		int distance;
		Vertex predecessor;
		String name;
		public Vertex(String name) {
			this.name= name;
		}
		@Override
		public String toString() {
			return name+" "+distance;
		}
	}

	static class Edge {
		public Edge(Vertex source, Vertex destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		Vertex source, destination;
		int weight;
	}

	public static void solve(ArrayList<Vertex> vertices, List<Edge> edges,
			Vertex source) {
		// This implementation takes in a graph, represented as lists of
		// vertices
		// and edges, and modifies the vertices so that their distance and
		// predecessor attributes store the shortest paths.

		// Step 1: initialize graph
		for (Vertex v : vertices) {
			if (v.equals(source)) {
				v.distance = 0;
			} else {
				v.distance = Integer.MAX_VALUE;
			}
			v.predecessor = null;
		}

		// Step 2: relax edges repeatedly
		for (int i = 0; i < vertices.size(); i++) {
			for (Edge uv : edges) {
				Vertex u = uv.source;
				Vertex v = uv.destination;
				if (u.distance + uv.weight < v.distance) {
					v.distance = u.distance + uv.weight;
					v.predecessor = u;
				}
			}
		}
		// Step 3: check for negative-weight cycles
		for (Edge uv : edges) {
			Vertex u = uv.source;
			Vertex v = uv.destination;
			if (u.distance + uv.weight < v.distance)
				System.err.println("Graph contains a negative-weight cycle");
		}
	}
	static public void add(List<Edge> v,Edge e){
		v.add(e);
		v.add(new Edge(e.destination,e.source,e.weight)); 
	}
	
	public static void main(String[] args) {
		ArrayList<Vertex> vertices = new ArrayList<BellmanFord.Vertex>();
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		Edge edges[] = {
				new Edge(v1, v6, 14),
				new Edge(v1, v3, 9),
				new Edge(v1, v2, 7),
				new Edge(v2, v3, 2),
				new Edge(v2, v4, 15),
				new Edge(v3, v6, 2),
				new Edge(v3, v4, 11),
				new Edge(v4, v5, 6),
				new Edge(v6, v5, 9)
				};
		ArrayList<Edge> edgesList = new ArrayList<BellmanFord.Edge>();
		for (int i = 0; i < edges.length; i++) {
			add(edgesList,edges[i]);
		}
		solve(vertices,edgesList,v1);
		print(vertices);
	}
	public static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
}
