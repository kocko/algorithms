package uva.volume123;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AsLongAsILearnILive implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), m = in.ni();

            int[] value = new int[n], next = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = in.ni();
                next[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni();
                if (next[u] == -1 || value[v] > value[next[u]]) {
                    next[u] = v;
                }
            }
            int sum = 0, last = 0;
            while (true) {
                sum += value[last];
                if (next[last] == -1) break;
                last = next[last];
            }

            out.printf("Case %d: %d %d\n", testCase, sum, last);
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
        try (AsLongAsILearnILive instance = new AsLongAsILearnILive()) {
            instance.solve();
        }
    }
}
