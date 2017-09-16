package codeforces.contests401_500.problemset463;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CaisaAndSugar implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), s = in.ni();
        int ans = 100;
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if (x < s) {
                if (y > 0) {
                    ans = Math.min(ans, y);
                }
            }
            if (x < s || (x == s && y == 0)) {
                ok = true;
            }
        }
        out.println(ok ? 100 - ans : -1);
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
        try (CaisaAndSugar instance = new CaisaAndSugar()) {
            instance.solve();
        }
    }
}
