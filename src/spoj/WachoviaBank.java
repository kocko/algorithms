package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WachoviaBank implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int k = in.ni();
            m = in.ni();
            weight = new int[m];
            value = new int[m];
            dp = new int[m][k + 1];
            for (int i = 0; i < m; i++) {
                weight[i] = in.ni();
                value[i] = in.ni();
                Arrays.fill(dp[i], -1);
            }
            out.printf("Hey stupid robber, you can get %d.\n", recurse(0, k));
        }
    }

    private int m;
    private int[] weight, value;
    private int[][] dp;
    
    private int recurse(int idx, int rem) {
        if (idx == m) return 0;
        if (dp[idx][rem] != -1) return dp[idx][rem];
        
        int ans = recurse(idx + 1, rem);
        if (weight[idx] <= rem) {
            ans = Math.max(ans, value[idx] + recurse(idx + 1, rem - weight[idx]));
        }
        return dp[idx][rem] = ans;
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
        try (WachoviaBank instance = new WachoviaBank()) {
            instance.solve();
        }
    }
}
