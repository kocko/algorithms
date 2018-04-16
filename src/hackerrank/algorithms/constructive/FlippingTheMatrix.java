package hackerrank.algorithms.constructive;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlippingTheMatrix implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            int n = in.ni();
            int[][] max = new int[n][n], x = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    x[i][j] = in.ni();
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max[i][j] = Math.max(x[i][j], x[i][2 * n - j - 1]);
                    max[i][j] = Math.max(max[i][j], x[2 * n - i - 1][2 * n - j - 1]);
                    max[i][j] = Math.max(max[i][j], x[2 * n - i - 1][j]);
                    result += max[i][j];
                }
            }
            out.println(result);
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
        try (FlippingTheMatrix instance = new FlippingTheMatrix()) {
            instance.solve();
        }
    }
}
