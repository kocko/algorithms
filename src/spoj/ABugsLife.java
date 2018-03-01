package spoj;

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

public class ABugsLife implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), m = in.ni();
            List<List<Integer>> graph = new ArrayList<>();
            int[] gender = new int[n];
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                gender[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni() - 1, v = in.ni() - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (!ok) break;
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                if (gender[i] == -1) {
                    queue.add(i);
                    gender[i] = 0;
                    while (!queue.isEmpty()) {
                        int top = queue.poll();
                        int expected = gender[top] ^ 1;
                        for (int v : graph.get(top)) {
                            if (gender[v] == -1) {
                                gender[v] = expected;
                                queue.add(v);
                            } else {
                                ok &= (gender[v] == expected);
                            }
                        }
                    }
                }
            }
            out.printf("Scenario #%d:\n", testCase);
            out.println(ok ? "No suspicious bugs found!" : "Suspicious bugs found!");
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
        try (ABugsLife instance = new ABugsLife()) {
            instance.solve();
        }
    }
}
