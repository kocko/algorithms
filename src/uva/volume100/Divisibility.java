package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            n = in.ni(); k = in.ni();
            dp = new Boolean[n][k];
            x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = abs(in.ni()) % k;
            }
            boolean can = recurse(0, x[0]);
            out.println(can ? "Divisible" : "Not divisible");
        }
    }

    private int n, k;
    private Boolean[][] dp;
    private int[] x;
    
    private Boolean recurse(int idx, int mod) {
        if (dp[idx][mod] != null) return dp[idx][mod];
        
        if (idx == n - 1) return mod == 0;
        
        int add = (mod + x[idx + 1]) % k;
        int sub = (mod + k - x[idx + 1]) % k;
        return dp[idx][mod] = recurse(idx + 1, add) | recurse(idx + 1, sub);
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
