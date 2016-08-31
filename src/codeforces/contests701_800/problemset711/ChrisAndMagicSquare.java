package codeforces.contests701_800.problemset711;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChrisAndMagicSquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(1);
            return;
        }
        long[][] grid = new long[n][n];
        long[] r = new long[n], c = new long[n];
        int a = 0, b = 0;
        long x = 0, y = 0;
        boolean main = false, secondary = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = in.ni();
                grid[i][j] = next;
                if (next == 0) {
                    a = i; b = j;
                    if (i == j) {
                        main = true;
                    }
                    if (i == n - j - 1) {
                        secondary = true;
                    }
                } else {
                    r[i] += next;
                    c[j] += next;
                    if (i == j) {
                        x += next;
                    }
                    if (i == n - 1 - j) {
                        y += next;
                    }
                }
            }
        }
        long diff;
        if (main && secondary) {
            diff = r[0] - x;
            x += diff;
            y += diff;
        } else if (main) {
            diff = y - x;
            x += diff;
        } else if (secondary) {
            diff = x - y;
            y += diff;
        } else {
            if (a == 0) {
                diff = r[1] - r[0];
            } else {
                diff = r[0] - r[a];
            }
        }
        grid[a][b] = diff;
        r[a] += diff;
        c[b] += diff;
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (r[i] != r[0]) {
                ok = false;
                break;
            }
            if (c[i] != c[0]) {
                ok = false;
                break;
            }
        }
        ok &= (x == y);
        ok &= (x == r[0]);
        ok &= (x == c[0]);
        ok &= (diff > 0);
        out.println(ok ? diff : -1);
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
        try (ChrisAndMagicSquare instance = new ChrisAndMagicSquare()) {
            instance.solve();
        }
    }
}
