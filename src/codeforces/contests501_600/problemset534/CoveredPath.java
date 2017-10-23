package codeforces.contests501_600.problemset534;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoveredPath implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int v1 = in.ni();
        v2 = in.ni();
        t = in.ni();
        d = in.ni();
        dp = new int[100][10000];
        for (int i = 0; i < 100; i++) Arrays.fill(dp[i], -1);
        out.println(recurse(0, v1));
    }

    private int v2, t, d;
    private int[][] dp;

    private int recurse(int time, int speed) {
        if (time == t - 1) {
            if (speed == v2) return v2;
            else return -100000;
        }
        if (dp[time][speed] != -1) return dp[time][speed];
        
        int ans = -100000;
        for (int diff = -d; diff <= d; diff++) {
            if (speed + diff > 0) {
                ans = Math.max(ans, speed + recurse(time + 1, speed + diff));
            }
        }
        return dp[time][speed] = ans;
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
        try (CoveredPath instance = new CoveredPath()) {
            instance.solve();
        }
    }
}
