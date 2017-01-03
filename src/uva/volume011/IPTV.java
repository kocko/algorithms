package uva.volume011;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IPTV {
    
    private static class Edge implements Comparable<Edge> {

        private int u;
        private int v;
        private int w;
        
        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private static class DisjointSet {
        private int[] root;
        private int[] size;

        public DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            int m = Integer.parseInt(sc.nextLine());
            Map<String, Integer> hash = new HashMap<>();
            int next = 1;
            PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
            for (int i = 0; i < m; i++) {
                String[] split = sc.nextLine().split("\\s+");
                if (!hash.containsKey(split[0])) {
                    hash.put(split[0], next++);
                }
                int u = hash.get(split[0]);
                if (!hash.containsKey(split[1])) {
                    hash.put(split[1], next++);
                }
                int v = hash.get(split[1]);
                queue.offer(new Edge(u, v, Integer.parseInt(split[2])));
            }
            DisjointSet dsu = new DisjointSet(n);
            long total = 0L;
            for (int i = 0; i < m; i++) {
                Edge edge = queue.poll();
                if (dsu.union(edge.u, edge.v)) {
                    total += edge.w;
                }
            }
            System.out.println(total);
            if (t > 0) {
                System.out.println();
            }
        }
        sc.close();
    }
}
