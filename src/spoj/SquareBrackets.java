package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SquareBrackets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            n = 2 * in.ni();
            int k = in.ni();
            final int MAX = 40;
            fixed = new boolean[MAX];
            dp = new int[MAX][MAX];
            for (int i = 0; i < MAX; i++) {
                Arrays.fill(dp[i], -1);
            }
            for (int i = 0; i < k; i++) {
                int next = in.ni();
                fixed[next - 1] = true;
            }
            out.println(recurse(0, 0));
        }
    }

    private int n;
    private boolean[] fixed;
    private int[][] dp;
    
    private int recurse(int idx, int open) {
        if (open < 0) return 0;
        if (idx == n) {
            if (open == 0) return 1;
            else return 0;
        }
        
        if (dp[idx][open] != -1) return dp[idx][open];
        
        if (fixed[idx]) {
            return dp[idx][open] = recurse(idx + 1, open + 1);
        } else {
            return dp[idx][open] = recurse(idx + 1, open + 1) + recurse(idx + 1, open - 1);
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
        try (SquareBrackets instance = new SquareBrackets()) {
            instance.solve();
        }
    }
}
