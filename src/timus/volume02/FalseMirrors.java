package timus.volume02;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class FalseMirrors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new int[n];
        dp = new Integer[1 << 20];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        out.println(recurse(0));
    }

    private int n;
    private int[] x;
    private Integer[] dp;
    
    private int recurse(int mask) {
        if (mask == (1 << n) - 1) return 0;
        if (dp[mask] != null) return dp[mask];
        
        int ans = 20000;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int b = (i + 1) % n, c = (i + 2) % n;
                int newMask = mask | (1 << i) | (1 << b) | (1 << c);
                int damage = 0;
                for (int j = 0; j < n; j++) {
                    if ((newMask & (1 << j)) == 0) {
                        damage += x[j];
                    }
                }
                ans = Math.min(ans, damage + recurse(newMask));
            }
        }
        return dp[mask] = ans;
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
        try (FalseMirrors instance = new FalseMirrors()) {
            instance.solve();
        }
    }
}
