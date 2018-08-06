package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Spiral implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[n][n];
        int number = 0, row = 0, col = 0, idx = 0;
        while (++number <= n * n) {
            result[row][col] = number;
            int[] d = dir[idx];
            if (row + d[0] >= n || row + d[0] < 0 || col + d[1] >= n || col + d[1] < 0 || result[row + d[0]][col + d[1]] != 0) {
                idx = (idx + 1) % 4;
                d = dir[idx];
            }
            row += d[0];
            col += d[1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(result[i][j]);
                out.print(' ');
            }
            out.println();
        }
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
        try (Spiral instance = new Spiral()) {
            instance.solve();
        }
    }
}
