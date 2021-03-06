package codeforces.contests1001_1100.problemset1016;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaAndTheMushrooms implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[][] grid = new long[2][n];
        for (int row = 0; row < 2; row++) {
            for (int i = 0; i < n; i++) {
                grid[row][i] = in.ni();
            }
        }
        
        long[] a = new long[n + n], b = new long[n + n], up = new long[n + n], down = new long[n + n];
        for (int i = 0; i < n; i++) {
            a[i] = b[2 * n - i - 1] = grid[0][i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = a[2 * n - i - 1] = grid[1][i];
        }

        int start = n - 1;
        if (start % 2 == 1) start--;
        int jump = 4;
        for (int idx = start; idx >= 0; idx -= 2) {
            long value;
            int t = 2 * idx;
            if (idx == start) {
                if (start % 2 == 1) {
                    value = t * grid[0][start] + (t + 1) * grid[0][start + 1] + (t + 2) * grid[1][start + 1] + (t + 3) * grid[1][start];
                } else {
                    value = t * grid[0][start] + (t + 1) * grid[1][start];
                }
            } else {
                value = t * grid[0][idx] + (t + 1) * grid[0][idx + 1] + up[idx + 2] + (t + jump) * grid[1][idx + 1] + (t + jump + 1) * grid[1][idx];
                jump += 4;
            }
            up[idx] = value;
        }
        out.println(1);
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
        try (VasyaAndTheMushrooms instance = new VasyaAndTheMushrooms()) {
            instance.solve();
        }
    }
}
