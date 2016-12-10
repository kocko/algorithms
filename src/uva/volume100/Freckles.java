package uva.volume100;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Freckles {

    private class DisjointSet {
        private int[] root;
        private int[] size;

        public DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        public boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
        }

    }

    private class Edge implements Comparable<Edge> {
        int x;
        int y;
        double w;

        private Edge(int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    public void solve(List<Point> points) {
        int n = points.size();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                queue.add(buildEdge(points.get(i), points.get(j)));
            }
        }
        int limit = (n * (n - 1)) / 2;
        DisjointSet dsu = new DisjointSet(n);
        double total = 0d;
        for (int i = 0; i < limit; i++) {
            Edge next = queue.poll();
            if (dsu.union(next.x, next.y)) {
                total += next.w;
            }
        }
        System.out.println(new DecimalFormat("0.00").format(total));
    }

    private Edge buildEdge(Point a, Point b) {
        double x = Math.abs(a.x - b.x);
        double y = Math.abs(a.y - b.y);
        double dist = Math.sqrt(x * x + y * y);
        return new Edge(a.index, b.index, dist);
    }

    static class Point {
        int index;
        double x;
        double y;

        private Point(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] split = sc.nextLine().split("\\s+");
                list.add(new Point(i, Double.parseDouble(split[0]), Double.parseDouble(split[1])));
            }
            new Freckles().solve(list);
            if (t >= 1) System.out.println();
        }
        sc.close();
    }

}
