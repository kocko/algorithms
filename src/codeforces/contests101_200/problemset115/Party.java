package codeforces.contests101_200.problemset115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Party {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int visitedCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n + 1];
        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sup = sc.nextInt();
            if (sup != -1) {
                List<Integer> neighbours = graph.getOrDefault(sup, new ArrayList<>());
                neighbours.add(i);
                graph.put(sup, neighbours);
                neighbours = graph.getOrDefault(i, new ArrayList<>());
                neighbours.add(sup);
                graph.put(i, neighbours);
            } else {
                roots.add(i);
            }
        }
        int answer = 0;
        for (Integer r : roots) {
            if (!visited[r]) {
                visited[r] = true;
                visitedCount++;
                int depth = bfs(Arrays.asList(r));
                answer = Math.max(answer, depth);
            }
        }

        System.out.println(answer);
        sc.close();
    }

    static int bfs(List<Integer> edges) {
        if (edges.size() == 0) return 0;
        List<Integer> nextLevel = new ArrayList<>();
        for (Integer edge : edges) {
            List<Integer> neighbours = graph.get(edge);
            if (neighbours != null) {
                for (Integer neighbour : graph.get(edge)) {
                    if (!visited[neighbour]) {
                        nextLevel.add(neighbour);
                        visited[neighbour] = true;
                        visitedCount++;
                    }
                }
            }
        }
        return 1 + bfs(nextLevel);
    }

}