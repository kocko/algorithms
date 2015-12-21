package codeforces.contests600_699.problemset609;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumSpanningTreeForEachEdge {

    static class Edge {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static int N, M;

    static Edge[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new Edge[M];
        Edge[] copy = new Edge[M];
        for (int i = 0; i < M; i++) {
            graph[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            copy[i] = graph[i];
        }
        sc.close();
        Arrays.sort(copy, Comparator.comparing(Edge::getWeight));
        findMSTWeightIncludingEachEdge(copy);
    }

    static void findMSTWeightIncludingEachEdge(Edge[] copy) {
        for (int i = 0; i < M; i++) {
            int result = graph[i].weight;
            boolean[] used = new boolean[N + 1];
            used[graph[i].x] = true;
            used[graph[i].y] = true;
            int usedCount = 2;
            for (int j = 0; j < M; j++) {
                if (usedCount == M) break;
                if (!used[copy[j].x] || !used[copy[j].y]) {
                    usedCount += used[copy[j].x] ? 0 : 1;
                    usedCount += used[copy[j].y] ? 0 : 1;
                    used[copy[j].x] = used[copy[j].y] = true;
                    result += copy[j].weight;
                }
            }
            System.out.println(result);
        }
    }

}
