package codeforces.contests601_700.problemset678;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IteratedLinearFunction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final long MOD = (long) 1e9 + 7;
    
    public void solve() {
        int a = in.ni(), b = in.ni();
        long n = in.nl(), x = in.nl();
        long[][] matrix = {{a, b}, {0, 1}};
        matrix = power(matrix, n);
        long result = (matrix[0][0] * x) % MOD;
        result = (result + matrix[0][1]) % MOD;
        out.println(result);
    }

    private long[][] power(long[][] m, long p) {
        int n = m.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1L;
        }
        while (p > 0) {
            if (p % 2 == 1) result = multiply(result, m);
            m = multiply(m, m);
            p >>= 1L;
        }
        return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
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
        try (IteratedLinearFunction instance = new IteratedLinearFunction()) {
            instance.solve();
        }
    }
}
