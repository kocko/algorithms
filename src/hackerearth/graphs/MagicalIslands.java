package hackerearth.graphs;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MagicalIslands implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out, true);

    public void solve() throws IOException {
        int n = in.ni(), m = in.ni();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            reverse.get(v).add(u);
        }
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int node = order.get(i);
            if (visited[node]) {
                current = 0;
                dfs2(node);
                if (current > max) max = current;
            }
        }
        out.println(max);
    }
    
    private List<List<Integer>> graph = new ArrayList<>(), reverse = new ArrayList<>();
    private List<Integer> order = new ArrayList<>();
    private int current = 0, max = 0;
    private boolean[] visited;
    
    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) if (!visited[next]) dfs1(next);
        order.add(node);
    }
    
    private void dfs2(int node) {
        visited[node] = false;
        current++;
        for (int next : reverse.get(node)) if (visited[next]) dfs2(next);
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
        new Thread(null, () -> {
            try {
                new MagicalIslands().solve();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "1", 1 << 23).start();
    }
}
