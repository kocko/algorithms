package uva.volume100;

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

public class LongestPaths implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, testCase = 1;
        while ((n = in.ni()) != 0) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            int start = in.ni();
            int u, v;
            while ((u = in.ni()) != 0 | (v = in.ni()) != 0) {
                graph.get(u).add(v);
            }
            int[] dist = new int[n + 1];
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.offerFirst(start);
            while (deque.size() > 0) {
                int current = deque.pollFirst();
                for (int next : graph.get(current)) {
                    if (dist[next] < dist[current] + 1) {
                        dist[next] = dist[current] + 1;
                        deque.addLast(next);
                    }
                }
            }
            int max = 0, finish = start;
            for (int i = 1; i <= n; i++) {
                if (dist[i] > max) {
                    max = dist[i];
                    finish = i;
                }
            }
            out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", testCase++, start, max, finish);
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
        try (LongestPaths instance = new LongestPaths()) {
            instance.solve();
        }
    }
}
