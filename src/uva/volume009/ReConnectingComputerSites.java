package uva.volume009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReConnectingComputerSites {
    
    private List<Edge> newEdges;
    private List<List<Edge>> spanningTree;
    private int total;
    
    private ReConnectingComputerSites(List<Edge> newEdges, List<List<Edge>> spanningTree, int total) {
        this.newEdges = newEdges;
        this.spanningTree = spanningTree;
        this.total = total;
    }
    
    public void solve() {
        int size = spanningTree.size() + 1;
        visited = new boolean[size + 1];
        for (Edge next : newEdges) {
            int u = next.x, v = next.y, w = next.w;
            heaviest = null;
            visited = new boolean[size + 1];
            dfs(u, v, new Edge(0, 0, 0));
            if (heaviest.w > w) {
                removeEdge(heaviest.x, heaviest.y);
                removeEdge(heaviest.y, heaviest.x);
                spanningTree.get(u).add(next);
                spanningTree.get(v).add(next.reverse());
                total = total - heaviest.w + w;
            }
        }
        System.out.println(total);
    }
    
    private void removeEdge(int x, int y) {
        Iterator<Edge> iterator = spanningTree.get(x).iterator();
        while (iterator.hasNext()) {
            Edge next = iterator.next();
            if (next.y == y) {
                iterator.remove();
                break;
            }
        }
    }
    
    private boolean[] visited;
    private Edge heaviest;
    
    private void dfs(int u, int v, Edge maxSoFar) {
        if (u == v) {
            heaviest = maxSoFar;
        }
        visited[u] = true;
        List<Edge> neighbours = spanningTree.get(u);
        for (Edge next : neighbours) {
            if (!visited[next.y]) {
                if (next.w > maxSoFar.w) {
                    dfs(next.y, v, next);    
                } else {
                    dfs(next.y, v, maxSoFar);
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int x;
        private int y;
        private int w;
        
        private Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        
        private Edge reverse() {
            return new Edge(y, x, w);
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            List<List<Edge>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            int oldCost = 0;
            for (int i = 0; i < n - 1; i++) {
                String[] split = sc.nextLine().split("\\s+");
                int u = Integer.parseInt(split[0]);
                int v = Integer.parseInt(split[1]);
                int w = Integer.parseInt(split[2]);
                Edge edge = new Edge(u, v, w);
                adj.get(u).add(edge);
                adj.get(v).add(edge.reverse());
                oldCost += Integer.parseInt(split[2]);
            }
            List<Edge> newEdges = new ArrayList<>();
            int k = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < k; i++) {
                String[] split = sc.nextLine().split("\\s+");
                int u = Integer.parseInt(split[0]);
                int v = Integer.parseInt(split[1]);
                if (u > v) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                int w = Integer.parseInt(split[2]);
                newEdges.add(new Edge(u, v, w));
            }
            int m = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < m; i++) {
                sc.nextLine();
            }
            System.out.println(oldCost);
            ReConnectingComputerSites instance = new ReConnectingComputerSites(newEdges, adj, oldCost);
            instance.solve();
            if (sc.hasNextLine()) {
                System.out.println();
                sc.nextLine();
            }
        }
        sc.close();
    }
    
}
