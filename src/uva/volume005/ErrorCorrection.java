package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ErrorCorrection implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            int[][] grid = new int[n][n];
            int[] row = new int[n], col = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.ni();
                    if (grid[i][j] == 1) {
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            int oddRows = 0, oddCols = 0;
            for (int i = 0; i < n; i++) {
                if (row[i] % 2 == 1) oddRows++;
                if (col[i] % 2 == 1) oddCols++;
            }
            if (oddRows == 0 && oddCols == 0) {
                out.println("OK");
            } else if (oddRows == 1 && oddCols == 1) {
                out:for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (row[i] % 2 == 1 && col[j] % 2 == 1) {
                            out.printf("Change bit (%d,%d)\n", (i + 1), (j + 1));
                            break out;
                        }
                    }
                }
            } else {
                out.println("Corrupt");
            }
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
        try (ErrorCorrection instance = new ErrorCorrection()) {
            instance.solve();
        }
    }
}
