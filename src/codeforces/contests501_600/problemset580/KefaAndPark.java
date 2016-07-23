package codeforces.contests501_600.problemset580;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KefaAndPark {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] catOn;

    static int[] leaf;
    static boolean[] visited;

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        catOn = new int[n + 1];
        leaf = new int[n + 1];
        visited = new boolean[n + 1];
        leaf[1] = 1;
        for (int i = 1; i <= n; i++) {
            catOn[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            saveNode(a, b);
            leaf[a]++;
            leaf[b]++;
        }
        sc.close();
        dfs(1, catOn[1]);
        System.out.println(result);
    }

    static void saveNode(int a, int b) {
        List<Integer> neighbours = graph.getOrDefault(a, new ArrayList<>());
        neighbours.add(b);
        graph.put(a, neighbours);

        neighbours = graph.getOrDefault(b, new ArrayList<>());
        neighbours.add(a);
        graph.put(b, neighbours);
    }

    static boolean isLeaf(int n) {
        return leaf[n] == 1;
    }

    static int result;

    static void dfs(int node, int cats) {
        visited[node] = true;
        if (cats <= m) {
            if (isLeaf(node)) {
                result++;
            } else {
                List<Integer> neighbours = graph.get(node);
                for (Integer i : neighbours) {
                    if (!visited[i]) {
                        dfs(i, (catOn[i] == 1) ? (cats + 1) : 0);
                    }
                }
            }
        }
    }
}
