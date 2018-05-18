package codeforces.contests901_1000.problemset982;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CutEmAll implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n % 2 == 1) {
            out.println(-1);
            return;
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        size = new int[n + 1];
        dfs(1, -1);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (size[i] % 2 == 0) {
                result++;
            }
        }
        out.println(result - 1);
    }
    
    private int[] size;
    private List<List<Integer>> graph = new ArrayList<>();
    
    private void dfs(int u, int parent) {
        size[u] = 1;
        for (int v : graph.get(u)) {
            if (v != parent) {
                dfs(v, u);
                size[u] += size[v];
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
        try (CutEmAll instance = new CutEmAll()) {
            instance.solve();
        }
    }
}
