package codeforces.contests501_600.problemset510;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoxAndTwoDots {

    static int n, m;
    static char[][] graph;

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> path;

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            char[] next = sc.next().toCharArray();
            System.arraycopy(next, 0, graph[i], 1, m);
        }
        visited = new boolean[n + 2][m + 2];
        run();
        sc.close();
    }

    static void run() {
        boolean result;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                path = new ArrayList<>();
                path.add(new int[]{i, j});
                if (!visited[i][j]) {
                    dfs(i, j, 1);
                    result = dfs;
                    if (result) {
                        System.out.println("Yes");
                        return;
                    }
                    for (int[] cell : path) {
                        visited[cell[0]][cell[1]] = false;
                    }
                }
            }
        }
        System.out.println("No");
    }

    static boolean dfs = false;

    static void dfs(int i, int j, int currentLength) {
        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 1 && x <= n && y >= 1 && y <= m) {
                int[] start = path.get(0);
                if (currentLength >= 4 && (x == start[0] && y == start[1])) {
                    dfs = true;
                    return;
                } else if (!visited[x][y] && (graph[x][y] == graph[i][j])) {
                    path.add(new int[]{x, y});
                    dfs(x, y, currentLength + 1);
                }
            }
        }
    }

}