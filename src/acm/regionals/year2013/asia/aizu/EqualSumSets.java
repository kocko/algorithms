package acm.regionals.year2013.asia.aizu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EqualSumSets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, k, s;
        while ((n = in.ni()) != 0 && (k = in.ni()) != 0 && (s = in.ni()) != 0) {
            dp = new int[n + 1][k + 1][s + 1];
            for (int[][] table : dp) {
                for (int[] row : table) {
                    Arrays.fill(row, -1);
                }
            }
            out.println(recurse(n, k, s));
        }
    }

    private int[][][] dp;

    private int recurse(int n, int count, int sum) {
        if (sum < 0 || count < 0) return 0; 
        if (n == 0) {
            return (sum == 0 && count == 0) ? 1 : 0;    
        }
        if (dp[n][count][sum] != -1) return dp[n][count][sum];
        
        int ans = recurse(n - 1, count, sum) + recurse(n - 1, count - 1, sum - n);
        
        return dp[n][count][sum] = ans;
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
        try (EqualSumSets instance = new EqualSumSets()) {
            instance.solve();
        }
    }
}
