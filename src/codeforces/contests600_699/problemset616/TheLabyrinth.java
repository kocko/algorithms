package codeforces.contests600_699.problemset616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheLabyrinth {

    static int n, m;
    static char[][] graph;
    static int[][] result;
    static Map<Integer, List<int[]>> components;
    static boolean[][] visited;

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static List<int[]> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        graph = new char[n + 2][m + 2];
        result = new int[n + 2][m + 2];
        components = new HashMap<>();
        visited = new boolean[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            char[] next = reader.readLine().toCharArray();
            System.arraycopy(next, 0, graph[i], 1, m);
        }
        reader.close();
        run();
        print();
    }

    static void run() {
        int componentNumber = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == '.' && !visited[i][j]) {
                    path = new ArrayList<>();
                    path.add(new int[]{i, j});
                    dfs(i, j, path);
                    components.put(componentNumber, path);
                    for (int[] cell : path) {
                        result[cell[0]][cell[1]] = componentNumber;
                    }
                    componentNumber++;
                }
            }
        }
    }

    static void dfs(int i, int j, List<int[]> path) {
        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 1 && x <= n && y >= 1 && y <= n) {
                if (graph[x][y] == '.' && !visited[x][y]) {
                    path.add(new int[]{x, y});
                    dfs(x, y, path);
                }
            }
        }
    }

    static void print() throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == '.') out.write(".");
                else {
                    boolean[] used = new boolean[components.size() + 1];
                    int score = 1;
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (graph[x][y] == '.') {
                            int component = result[x][y];
                            if (!used[component]) {
                                used[component] = true;
                                score += components.get(component).size();
                            }
                        }
                    }
                    out.write((char) ('0' + score % 10));
                }
            }
            out.write("\n");
        }
        out.flush();
    }
}

/*
    test with:
    1 3
    *..
*/


