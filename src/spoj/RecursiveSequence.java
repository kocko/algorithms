package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int k = in.ni();
            long[] b = new long[k], c = new long[k];
            for (int i = 0; i < k; i++) b[i] = in.nl();
            for (int i = 0; i < k; i++) c[i] = in.nl();
            int n = in.ni();
            findNumber(b, c, n);
        }
    }
    
    private void findNumber(long[] vector, long[] c, int n) {
        int k = c.length;
        if (n <= k) {
            out.println(vector[n - 1]);
        } else {
            long[][] matrix = buildMatrix(c);
            matrix = multiply(new long[][]{vector}, power(matrix, n - k));
            out.println(matrix[0][k - 1]);
        }
    }

    private long[][] buildMatrix(long[] c) {
        long[][] matrix = new long[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            matrix[i][c.length - 1] = c[c.length - i - 1];
            if (i > 0) matrix[i][i - 1] = 1;
        }
        return matrix;
    }
    
    private long[][] multiply(long[][] a, long[][] b) {
        final long MOD = (long) 1e9;
        long[][] result = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    long value = (a[i][k] * b[k][j]) % MOD;
                    result[i][j] = (result[i][j] + value) % MOD;
                }
            }
        }
        return result;
    }
    
    private long[][] power(long[][] matrix, long p) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1L;
        while (p > 0) {
            if (p % 2 == 1) result = multiply(result, matrix);
            matrix = multiply(matrix, matrix);
            p >>= 1;
        }
        return result;
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
