package codeforces.contests701_800.problemset710;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicOddSquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] result = new int[n][n];
        int nextOdd = 1, nextEven = 0;
        for (int i = 0; i < n; i++) {
            int odds = 2 * Math.min(i, n - i - 1) + 1;
            int evens = (n - odds) / 2;
            for (int j = 0; j < evens; j++) {
                result[i][j] = (nextEven += 2);
                result[i][n - evens + j] = (nextEven += 2);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    out.print(nextOdd + " ");
                    nextOdd += 2;
                } else {
                    out.print(result[i][j] + " ");
                }
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
        try (MagicOddSquare instance = new MagicOddSquare()) {
            instance.solve();
        }
    }
}
