package codeforces.contests701_800.problemset736;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OstapAndGrasshopper implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        int g = 0, t = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == 'T') t = i;
            else if (x[i] == 'G') g = i;
        }
        boolean ok = false;
        if (g == t) {
            out.println("YES");
        } else if (g < t) {
            while (true) {
                if (g == t) {
                    ok = true;
                    break;
                }
                if (g + k <= n - 1 && x[g + k] != '#') {
                    g += k;
                } else if (g + k >= n || x[g + k] == '#') break;
            }
        } else {
            while (true) {
                if (g == t) {
                    ok = true;
                    break;
                }
                if (g - k >= 0 && x[g - k] != '#') {
                    g -= k;
                } else if (g - k < 0 || x[g - k] == '#') break;
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
        try (OstapAndGrasshopper instance = new OstapAndGrasshopper()) {
            instance.solve();
        }
    }
}
