package uva.volume110;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Beverages {

    private int[][] graph;
    private Map<Integer, String> inverse;

    private Beverages(int[][] graph, Map<Integer, String> inverse) {
        this.graph = graph;
        this.inverse = inverse;
    }

    public void solve(int testCase) {
        int root = -1;
        int n = graph.length - 1;
        for (int i = 1; i <= n; i++) {
            boolean ok = true;
            for (int j = 1; j <= n; j++) {
                if (graph[j][i] == 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                root = i;
                break;
            }
        }
        visited = new boolean[n + 1];
        order = new Stack<>();
        dfs(root);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.print("Case #" + testCase + ": Dilbert should drink beverages in this order: ");
        for (Integer i : order) {
            System.out.print(inverse.get(i) + " ");
        }
        System.out.println();
    }

    private boolean[] visited;
    private Stack<Integer> order;

    private void dfs(int x) {
        visited[x] = true;
        for (int u = 1; u <= graph.length - 1; u++) {
            if (!visited[u] && graph[x][u] == 1) {
                dfs(u);
            }
        }
        order.push(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 1;
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, Integer> order = new HashMap<>();
            Map<Integer, String> inverse = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                String next = sc.nextLine();
                order.put(next, i);
                inverse.put(i, next);
            }
            int m = Integer.parseInt(sc.nextLine());
            int[][] graph = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                String[] split = sc.nextLine().split("\\s+");
                graph[order.get(split[1])][order.get(split[0])] = 1;
            }
            new Beverages(graph, inverse).solve(testCase++);
        }
        sc.close();
    }

}
