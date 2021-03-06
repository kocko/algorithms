package uva.volume114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class Squares implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

     public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            out.println(recurse(in.ni()));
        }
    }

    private Integer[] dp = new Integer[10001];

    private Integer recurse(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (dp[x] != null) return dp[x];

        int ans = 100;
        for (int i = 1; i * i <= x; i++) {
            ans = min(ans, recurse(x - i * i) + 1);
        }
        return dp[x] = ans;
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
        try (Squares instance = new Squares()) {
            instance.solve();
        }
    }
}
