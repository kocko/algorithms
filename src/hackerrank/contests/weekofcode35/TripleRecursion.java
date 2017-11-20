package hackerrank.contests.weekofcode35;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TripleRecursion implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        k = in.ni();
        matrix = new int[n][n];
        recurse(0, 0, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(matrix[i][j]);
                out.print(' ');
            }
            out.println();
        }
    }

    private int n, m, k;

    private int[][] matrix;

    private void recurse(int i, int j, int value) {
        if (i < n && j < n) {
            matrix[i][j] = value;
            if (i == j) {
                recurse(i + 1, j, value - 1);
                recurse(i, j + 1, value - 1);
                recurse(i + 1, j + 1, value + k);
            } else if (i > j) {
                recurse(i + 1, j, value - 1);
            } else {
                recurse(i, j + 1, value - 1);
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
        try (TripleRecursion instance = new TripleRecursion()) {
            instance.solve();
        }
    }
}
