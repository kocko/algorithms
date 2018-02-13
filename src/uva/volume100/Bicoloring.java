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
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Bicoloring implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            int m = in.ni();
            List<List<Integer>> graph = new ArrayList<>();
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                color[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            boolean bipartite = true;
            for (int i = 0; i < n; i++) {
                if (color[i] == -1) {
                    queue.add(i);
                    color[i] = 0;
                    while (!queue.isEmpty()) {
                        int top = queue.poll();
                        for (int v : graph.get(top)) {
                            if (color[v] == -1) {
                                color[v] = color[top] ^ 1;
                                queue.add(v);
                            } else {
                                bipartite &= color[top] != color[v];
                            }
                        }
                    }
                }
            }
            if (!bipartite) {
                out.print("NOT ");
            }
            out.println("BICOLORABLE.");
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
        try (Bicoloring instance = new Bicoloring()) {
            instance.solve();
        }
    }
}
