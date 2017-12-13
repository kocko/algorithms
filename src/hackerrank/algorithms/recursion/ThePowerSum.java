package hackerrank.algorithms.recursion;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThePowerSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        x = in.ni();
        n = in.ni();
        dp = new int[1001][33];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 33; j++) {
                dp[i][j] = -1;
            }
        }
        out.println(recurse(x, 1));
    }
    
    private int n, x;
    private int[][] dp;
    
    private int recurse(int current, int last) {
        if (current == 0) return 1;
        if (current < 0) return 0;
        
        if (dp[current][last] != -1) return dp[current][last];
        
        int ans = 0;
        int power = power(last);
        if (power != -1) {
            ans += recurse(current - power, last + 1) + recurse(current, last + 1);
        }
        
        return dp[current][last] = ans; 
    }
    
    private int power(int k) {
        int result = k;
        for (int i = 2; i <= n; i++) {
            result *= k;
            if (result > x) return -1;
        }
        return result;
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
        try (ThePowerSum instance = new ThePowerSum()) {
            instance.solve();
        }
    }
}
