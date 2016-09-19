package hackerrank.contests.weekofcode23;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lighthouse implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    double r = 1.0;
                    out: while (true) {
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < n; b++) {
                                if (dist(a, b, i, j) <= r && grid[a][b] == '*') {
                                    break out;
                                }
                            }
                        }
                        if (i + r >= n || j + r >= n || i - r < 0 || j - r < 0) break;
                        r++;
                    }
                    if (r > max) {
                        max = (int) r - 1;
                    }
                }
            }
        }
        out.println(max);
    }
    
    private double dist(int a, int b, int i, int j) {
        int m = (i - a) * (i - a);
        int n = (j - b) * (j - b);
        return Math.sqrt(m + n);
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
        try (Lighthouse instance = new Lighthouse()) {
            instance.solve();
        }
    }
}
