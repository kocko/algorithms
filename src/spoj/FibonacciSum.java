package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FibonacciSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final int MOD = (int) 1e9 + 7;
    
    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            long result = (sum(m) - sum(n - 1));
            if (result <= 0) result += MOD;
            out.println(result % MOD);
        }
    }
    
    private long sum(int n) {
        if (n <= 0) return 0;
        long[][] vector = {{1, 0, 1}};
        long[][] matrix = new long[][]{{1, 0, 0}, {1, 0, 1}, {1, 1, 1}};
        matrix = multiply(vector, power(matrix, n - 1));
        return matrix[0][0];
    }
    
    private long[][] power(long[][] matrix, int n) {
        long[][] result = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) result[i][i] = 1;
        while (n > 0) {
            if (n % 2 == 1) result = multiply(result, matrix);
            matrix = multiply(matrix, matrix);
            n >>= 1;
        }
        return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    long value = (a[i][k] * b[k][j]) % MOD;
                    result[i][j] += value;
                    result[i][j] %= MOD;
                }
            }
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
        try (FibonacciSum instance = new FibonacciSum()) {
            instance.solve();
        }
    }
}
