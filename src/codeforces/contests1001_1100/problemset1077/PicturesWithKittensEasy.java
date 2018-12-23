package codeforces.contests1001_1100.problemset1077;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.max;

public class PicturesWithKittensEasy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        k = in.ni();
        x = in.ni();
        beauty = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            beauty[i] = in.nl();
        }
        dp = new Long[201][201][201];
        Long ans = recurse(1, 0, 0);
        out.println(ans <= 0 ? -1 : ans);
    }
    
    private int n, k, x;
    private long[] beauty;
    private Long[][][] dp;
    
    private Long recurse(int idx, int reposts, int last) {
        final long oo = 1234567890123L;
        if (idx - last > k) return -oo;
        if (idx == n + 1) return 0L;
        
        if (dp[idx][reposts][last] != null) return dp[idx][reposts][last];
        
        long ans = recurse(idx + 1, reposts, last);
        if (reposts < x) {
            ans = max(ans, beauty[idx] + recurse(idx + 1, reposts + 1, idx));
        }
        
        return dp[idx][reposts][last] = ans;
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
        try (PicturesWithKittensEasy instance = new PicturesWithKittensEasy()) {
            instance.solve();
        }
    }
}
