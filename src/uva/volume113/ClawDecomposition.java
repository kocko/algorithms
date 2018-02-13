package uva.volume113;

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

public class ClawDecomposition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] color = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                color[i] = -1;
            }
            int u, v;
            while ((u = in.ni()) != 0 | (v = in.ni()) != 0) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            boolean bipartite = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == -1) {
                    queue.offerLast(i);
                    color[i] = 0;
                    while (!queue.isEmpty()) {
                        int top = queue.pollFirst();
                        for (int next : graph.get(top)) {
                            if (color[next] == -1) {
                                color[next] = color[top] ^ 1;
                                queue.offer(next);
                            } else {
                                bipartite &= color[top] != color[next];
                            }
                        }
                    }
                }
            }
            out.println(bipartite ? "YES" : "NO");
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
        try (ClawDecomposition instance = new ClawDecomposition()) {
            instance.solve();
        }
    }
}
