package codeforces.contests600_699.problemset615;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LongtailHedgehog {

    static Map<Integer, Set<Integer>> graph = new HashMap<>();

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n + 1];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            addInfo(start, end);
            addInfo(end, start);
        }
        sc.close();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }
        System.out.println(ans);
    }

    static void addInfo(int start, int end) {
        if (graph.containsKey(start)) {
            Set<Integer> set = graph.get(start);
            set.add(end);
            graph.put(start, set);
        } else {
            graph.put(start, new TreeSet<Integer>(){{ add(end); }});
        }
    }

    static boolean[] visited;

    static void dfs(int i, int currentLength) {
        visited[i] = true;
        Set<Integer> neighbours = graph.get(i);
        if (neighbours != null) {
            for (Integer n : neighbours) {
                if (!visited[n] && n > i) {
                    ans = Math.max(ans, (currentLength + 1) * graph.get(n).size());
                    dfs(n, currentLength + 1);
                }
            }
        }
    }
}
