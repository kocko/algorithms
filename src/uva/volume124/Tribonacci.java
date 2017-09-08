package uva.volume124;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tribonacci implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n;
        while ((n = in.nl()) != 0L) {
            tribonacci(n);
        }
    }

    private void tribonacci(long n) {
        long[][] vector = {{0L, 1L, 2L}};
        long[][] matrix = { {0, 0, 1},
                            {1, 0, 1},
                            {0, 1, 1} };
        matrix = multiply(vector, power(matrix, n - 1));
        out.println(matrix[0][0]);
    }

    private long[][] multiply(long[][] a, long[][] b) {
        long MOD = (long) (1e9 + 9);
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
        for (int i = 0; i < n; i++) {
            result[i][i] = 1L;
        }
        while (p > 0) {
            if (p % 2 == 1) result = multiply(result, matrix);
            matrix = multiply(matrix, matrix);
            p >>= 1L;
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
        try (Tribonacci instance = new Tribonacci()) {
            instance.solve();
        }
    }
}
