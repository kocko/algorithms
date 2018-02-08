package codeforces.contests001_100.problemset057;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class SquareEarth implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
        int x = 0, y = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int j = 0, idx = 0, number = 0;
        int[] d = dir[j];
        int[] indices = new int[2];
        for (int i = 0; i < 4 * n; i++) {
            if (x1 == x && y1 == y) {
                indices[idx++] = number;
            }
            if (x2 == x && y2 == y) {
                indices[idx++] = number;
            }
            if (idx == 2) break;
            if ((x == n && y == 0) || (x == n && y == n) || (x == 0 && y == n)) {
                d = dir[++j];
            }
            x += d[0];
            y += d[1];
            number++;
        }
        int result = min(indices[1] - indices[0], 4 * n - indices[1] + indices[0]);
        out.println(result);
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
        try (SquareEarth instance = new SquareEarth()) {
            instance.solve();
        }
    }
}
