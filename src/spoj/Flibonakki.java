package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Flibonakki implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) out.println(g(in.nl()));
    }

    private final long MOD = (long) 1e9 + 7;

    private long g(long n) {
        long[][] vector = {{0, 1, 1, 2, 0}};
        
        long[][] matrix = {{0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0},
                           {1, 1, 2, 3, 0}, 
                           {1, 2, 3, 5, 1}, 
                           {0, 0, 0, 0, 1}}; 
        vector = multiply(vector, power(matrix, n));
        return vector[0][4] % MOD;
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
    
    private long[][] power(long[][] m, long p) {
        int n = m.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1L;
        while (p > 0) {
            if (p % 2 == 1) result = multiply(result, m);
            m = multiply(m, m);
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
        try (Flibonakki instance = new Flibonakki()) {
            instance.solve();
        }
    }
}
