package Algorithms.spanningTree;

import java.util.ArrayList;

/**
 *
 * @author rcuser
 */
public class SpanningTrees {

    class Vertex {

        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    class Edge {

        Vertex a, b;
        int val;

        public Edge(Vertex a, Vertex b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            Edge ed = (Edge) obj;
            return ed.a == a && ed.b == b;
        }
    }

    public SpanningTrees() {
        ArrayList<Vertex> V = new ArrayList<Vertex>();
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        V.add(new Vertex(1, 1));
        ArrayList<Edge> E = new ArrayList<Edge>();
        E.add(new Edge(V.get(0), V.get(1), 7));
        E.add(new Edge(V.get(0), V.get(3), 5));
        E.add(new Edge(V.get(1), V.get(2), 8));
        E.add(new Edge(V.get(1), V.get(3), 9));
        E.add(new Edge(V.get(1), V.get(4), 7));
        E.add(new Edge(V.get(2), V.get(4), 5));
        E.add(new Edge(V.get(3), V.get(4), 15));
        E.add(new Edge(V.get(3), V.get(5), 6));
        E.add(new Edge(V.get(4), V.get(5), 6));
        E.add(new Edge(V.get(4), V.get(6), 6));
        E.add(new Edge(V.get(5), V.get(6), 6));
        int r = minWeight(V, E);
        System.err.println(r);
    }

    int minWeight(ArrayList<Vertex> V, ArrayList<Edge> E) {
        ArrayList<Vertex> newV = new ArrayList<Vertex>();
        newV.add(V.get(0));
        ArrayList<Edge> newE = new ArrayList<Edge>();
        Edge minE;
        do {
            minE = null;
            int minW = 0;
            for (Edge edge : E) {
                if (newV.contains(edge.a) && !newV.contains(edge.b)) {
                    if (minW < edge.val) {
                        minW = edge.val;
                        minE = edge;
                    }
                }
            }
            if (minE != null) {
                newE.add(minE);
                newV.add(minE.b);
            }
        } while (minE != null);

        int m = 0;
        for (int i = 0; i < newE.size(); i++) {
            m += newE.get(i).val;
        }
        return m;
    }

    public static void main(String[] args) {
        new SpanningTrees();
    }
}
