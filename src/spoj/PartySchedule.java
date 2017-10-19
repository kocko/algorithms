package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PartySchedule implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while ((t = in.ni()) != 0 && (n = in.ni()) != 0) {
            cost = new int[n];
            fun = new int[n];
            dp = new int[n][t + 1];
            for (int i = 0; i < n; i++) {
                cost[i] = in.ni();
                fun[i] = in.ni();
                Arrays.fill(dp[i], -1);
            }
            int maxFun = 0, cost = 0;
            for (int i = 1; i <= t; i++) {
                int fun = recurse(0, i);
                if (fun > maxFun) {
                    cost = i;
                    maxFun = fun;
                }
            }
            out.printf("%d %d\n", cost, maxFun);
        }
    }
    
    private int n, t;
    private int[] cost, fun;
    private int[][] dp;
    
    private int recurse(int idx, int rem) {
        if (idx == n) return 0;
        if (dp[idx][rem] != -1) return dp[idx][rem];
        
        int ans = recurse(idx + 1, rem);
        if (cost[idx] <= rem) {
            int take = fun[idx] + recurse(idx + 1, rem - cost[idx]);
            if (take >= ans) {
                ans = take;
            }
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
        try (PartySchedule instance = new PartySchedule()) {
            instance.solve();
        }
    }
}
