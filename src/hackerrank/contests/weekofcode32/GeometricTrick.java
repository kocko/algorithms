package hackerrank.contests.weekofcode32;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GeometricTrick implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private char[] s;

    public void solve() {
        int MAX = in.ni();
        char[] word = in.next().toCharArray();
        s = new char[MAX + 1];
        System.arraycopy(word, 0, s, 1, MAX);
        int result = 0;
        for (int i = 1; i <= MAX; i++) {
            Map<Integer, Integer> factorization = factor(i);
            long minK = 1L;
            if (!isSquare(factorization)) {
                for (Map.Entry<Integer, Integer> prime : factorization.entrySet()) {
                    if (prime.getValue() % 2 == 1) {
                        minK *= prime.getKey();
                    }
                }
            }
            for (long t = 1L; ; t++) {
                long k = minK * t * t;
                long j = (long) Math.sqrt(k * i);
                if (j <= MAX && k <= MAX) {
                    if (ok(i, (int) j, (int) k)) {
                        result++;
                    }
                } else break;
            }
        }
        out.println(result);
    }
    
    private Map<Integer, Integer> factor(int n) {
        Map<Integer, Integer> factorization = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factorization.put(i, factorization.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            factorization.put(n, 1);
        }
        return factorization;
    }
    
    private boolean isSquare(Map<Integer, Integer> factorization) {
        boolean even = true;
        for (Map.Entry<Integer, Integer> entry : factorization.entrySet()) {
            even &= entry.getValue() % 2 == 0;
        }
        return even;
    }

    private boolean ok(int i, int j, int k) {
        return s[i] == 'a' && s[j] == 'b' && s[k] == 'c';
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
        try (GeometricTrick instance = new GeometricTrick()) {
            instance.solve();
        }
    }
}
