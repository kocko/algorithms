package timus.volume12;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TopologicalSorting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            degree[v]++;
        }
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = in.ni();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            int next = order[i];
            if (queue.remove(next)) {
                for (int v : graph.get(next)) {
                    if (--degree[v] == 0) {
                        queue.offer(v);
                    }
                }
            } else {
                ok = false;
                break;
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (TopologicalSorting instance = new TopologicalSorting()) {
            instance.solve();
        }
    }
}
