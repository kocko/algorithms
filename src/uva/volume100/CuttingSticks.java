package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class CuttingSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            int k = in.ni();
            points = new int[k + 2];
            for (int i = 1; i <= k; i++) {
                points[i] = in.ni();
            }
            points[k + 1] = n;
            dp = new int[k + 2][k + 2];
            for (int[] row : dp) Arrays.fill(row, -1);
            int ans = recurse(0, k + 1);
            out.printf("The minimum cutting is %d.\n", ans);
        }
    }

    private int[] points;
    private int[][] dp;

    private int recurse(int left, int right) {
        if (right - left < 2) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        int size = points[right] - points[left];
        int min = (int) 1e5;
        for (int i = left + 1; i < right; i++) {
            min = min(recurse(left, i) + recurse(i, right), min);
        }
        return dp[left][right] = size + min;
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
        try (CuttingSticks instance = new CuttingSticks()) {
            instance.solve();
        }
    }
}