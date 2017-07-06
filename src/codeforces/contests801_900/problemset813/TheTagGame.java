package codeforces.contests801_900.problemset813;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheTagGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), x = in.ni();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[n + 1];
        int[] distRoot = new int[n + 1];
        dfs(1, distRoot);

        visited = new boolean[n + 1];
        int[] distX = new int[n + 1];
        dfs(x, distX);
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (distRoot[i] > distX[i]) {
                ans = Math.max(ans, distRoot[i]);
            }
        }
        out.println(2 * ans);
    }
    
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    
    private void dfs(int root, int[] dist) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int top = queue.pop();
            visited[top] = true;
            for (int next : graph.get(top)) {
                if (!visited[next]) {
                    dist[next] = dist[top] + 1;
                    queue.add(next);
                }
            }
        }
    }
    
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (TheTagGame instance = new TheTagGame()) {
            instance.solve();
        }
    }
}
