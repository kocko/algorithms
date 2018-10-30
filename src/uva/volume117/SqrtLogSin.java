package uva.volume117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.log;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class SqrtLogSin implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != ~0) {
            out.println(recurse(n));
        }
    }

    private final int MAX = (int) 1e6 + 1, MOD = MAX - 1;
    private Integer[] dp = new Integer[MAX];

    private Integer recurse(int i) {
        if (i == 0) return 1;
        if (dp[i] != null) return dp[i];
        int a = (int) (i - sqrt(i));
        int b = (int) (log(i));
        int c = (int) (i * sin(i) * sin(i));
        int ans = recurse(a) + recurse(b) + recurse(c);
        return dp[i] = ans % MOD;
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
        try (SqrtLogSin instance = new SqrtLogSin()) {
            instance.solve();
        }
    }
}
