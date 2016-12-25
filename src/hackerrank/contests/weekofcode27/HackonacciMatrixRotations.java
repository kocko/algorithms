package hackerrank.contests.weekofcode27;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HackonacciMatrixRotations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), q = in.ni();
        long[][] matrix = new long[n][n];
        Map<Long, Long> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long a = (long) i + 1;
            for (int j = 0; j < n; j++) {
                long b = (long) j + 1;
                if (i > 6 || j > 6) {
                    matrix[i][j] = matrix[i % 7][j % 7];
                } else {
                    long key = a * b * a * b;
                    if (cache.containsKey(key)) {
                        matrix[i][j] = cache.get(key);
                    } else {
                        long t = h(key);
                        cache.put(key, t);
                        matrix[i][j] = t;
                    }
                }
            }
        }
        int[] d = new int[4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[1] += (matrix[i][j] ^ matrix[j][n - 1 - i]);
                d[2] += (matrix[i][j] ^ matrix[n - 1 - i][n - 1 - j]);
                d[3] += (matrix[i][j] ^ matrix[n - 1 - j][i]);
            }
        }
        while (q-- > 0) {
            int r = (in.ni() / 90) % 4;
            out.println(d[r]);
        }
    }
    
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    long x = (a[i][j] * b[j][k]) % 2;
                    result[i][k] = (result[i][k] + x) % 2;
                }
            }
        }
        return result;
    }
    
    private long[][] fastExponentiation(long[][] a, long n) {
        if (n == 1) return a;
        else {
            if (n % 2 == 0) {
                long[][] a1 = fastExponentiation(a, n / 2);
                return multiply(a1, a1);
            } else {
                return multiply(a, fastExponentiation(a, n - 1));
            }
        }
    }
    
    private long h(long n) {
        if (n <= 3) return n % 2;
        long[][] a = { {1, 0, 1}, {1, 0, 0}, {0, 1, 0} };
        long[][] exp = fastExponentiation(a, n - 3);
        return (exp[0][0] + exp[0][2]) % 2;
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
        try (HackonacciMatrixRotations instance = new HackonacciMatrixRotations()) {
            instance.solve();
        }
    }
}
