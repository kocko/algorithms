package codeforces.contests600_699.problemset616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TheLabyrinth {

    static int n, m;
    static char[][] graph;
    static int[][] result;
    static Map<Integer, Integer> components;
    static Set<int[]> visited;

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
        visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            char[] next = reader.readLine().toCharArray();
            System.arraycopy(next, 0, graph[i], 1, m);
        }
        reader.close();
        run();
        long end = System.currentTimeMillis();
    }

    static void run() {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int componentNumber = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Set<Integer> neighbourComponentNumbers = new HashSet<>();
                if (graph[i][j] == '.') {
                    out.write('.');
                } else {
                    int score = 1;
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 1 && x <= n && y >= 1 && y <= m) {
                            if (graph[x][y] == '*') continue;
                            if (result[x][y] == 0) {
                                path = new ArrayList<>();
                                path.add(new int[]{x, y});
                                visited = new HashSet<>();
                                result[x][y] = componentNumber;
                                dfs(x, y, path, componentNumber);
                                components.put(componentNumber, path.size());
                                neighbourComponentNumbers.add(componentNumber);
                                score += path.size();
                                componentNumber++;
                            } else {
                                int component = result[x][y];
                                if (!neighbourComponentNumbers.contains(component)) {
                                    score += components.get(component);
                                    neighbourComponentNumbers.add(component);
                                }
                            }
                        }
                    }
                    out.write('0' + (score % 10));
                }
            }
            out.write('\n');
        }
        out.flush();
    }

    static void dfs(int i, int j, List<int[]> path, int componentNumber) {
        visited.add(new int[]{i, j});
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            int[] cell = {x, y};
            if (x >= 1 && x <= n && y >= 1 && y <= m) {
                if (graph[x][y] == '.' && !visited(cell)) {
                    path.add(new int[]{x, y});
                    result[x][y] = componentNumber;
                    dfs(x, y, path, componentNumber);
                }
            }
        }
    }

    static boolean visited(int[] cell) {
        for (int[] c : visited) {
            if (c[0] == cell[0] && c[1] == cell[1]) return true;
        }
        return false;
    }

}
