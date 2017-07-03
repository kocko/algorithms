package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class DoubleHelix implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, m;
        while ((n = in.ni()) != 0) {
            int[] first = new int[n];
            for (int i = 0; i < n; i++) first[i] = in.ni();
            m = in.ni();
            int[] second = new int[m];
            for (int i = 0; i < m; i++) second[i] = in.ni();

            arrays = new int[][]{first, second};
            
            dp = new int[2][max(m, n)];
            for (int i = 0; i < 2; i++) Arrays.fill(dp[i], -1);
            
            out.println(Math.max(recurse(0, 0), recurse(1, 0)));
        }
    }

    private int[][] arrays;
    private int[][] dp;

    private int recurse(int row, int idx) {
        if (idx == arrays[row].length) return 0;

        if (dp[row][idx] != -1) return dp[row][idx];

        int ans = recurse(row, idx + 1);
        int a = idx(row ^ 1, arrays[row][idx]);
        if (a != -1) {
            ans = Math.max(ans, recurse(row ^ 1, a + 1));
        }
        return dp[row][idx] = arrays[row][idx] + ans;
    }

    private int idx(int array, int number) {
        int[] x = arrays[array];
        int left = 0, right = x.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x[mid] == number) return mid;
            else if (x[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
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
        try (DoubleHelix instance = new DoubleHelix()) {
            instance.solve();
        }
    }
}
