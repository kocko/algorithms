package codeforces.contests1001_1100.problemset1057;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class TanyaAndColoredCandies implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        int start = in.ni() - 1, k = in.ni();
        candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = in.ni();
        }
        char[] c = in.next().toCharArray();
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (c[i] == 'R') color[i] = 0;
            else if (c[i] == 'G') color[i] = 1;
            else color[i] = 2;
        }

        dp = new Integer[n][2001];
        int result = oo;
        for (int s = 0; s < n; s++) {
            int dist = abs(start - s);
            result = min(result, dist + recurse(s, k - candies[s]));
        }
        out.println(result == oo ? -1 : result);
    }

    private int n;
    private int oo = 10000;
    private int[] candies, color;
    private Integer[][] dp;

    private int recurse(int idx, int remaining) {
        if (remaining <= 0) return 0;
        if (dp[idx][remaining] != null) return dp[idx][remaining];

        int ans = oo;
        for (int next = 0; next < n; next++) {
            if (color[idx] != color[next] && candies[next] > candies[idx]) {
                int dist = abs(idx - next);
                ans = min(ans, dist + recurse(next, remaining - candies[next]));
            }
        }

        return dp[idx][remaining] = ans;
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
        try (TanyaAndColoredCandies instance = new TanyaAndColoredCandies()) {
            instance.solve();
        }
    }
}
