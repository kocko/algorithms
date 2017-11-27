package codeforces.contests201_300.problemset300;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        init();
        a = in.ni();
        b = in.ni();
        int n = in.ni(), min = Math.min(a, b), max = Math.max(a, b);
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int sum = (n - i) * min + i * max;
            if (isGood(sum)) {
                result += c(n, i);
                result %= MOD;
            }
        }
        out.println(result);
    }

    private int a, b, MOD = (int) 1e9 + 7;
    private long[] fact = new long[1000001];
    
    private void init() {
        fact[0] = 1L;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i);
            fact[i] %= MOD;
        }
    }
    
    private boolean isGood(int x) {
        boolean result = true;
        while (x > 0) {
            int rem = x % 10;
            result &= (rem == a || rem == b);
            x /= 10;
        }
        return result;
    }
    
    private long c(int n, int k) {
        long result = fact[n];
        long divisor = (fact[n - k] * fact[k]) % MOD;
        divisor = power(divisor, MOD - 2);
        return (result * divisor) % MOD;
    }
    
    private long power(long value, int degree) {
        if (degree == 0) return 1L;
        if (degree % 2 == 1) return (power(value, degree - 1) * value) % MOD;
        long result = power(value, degree >> 1);
        return (result * result) % MOD;
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
        try (BeautifulNumbers instance = new BeautifulNumbers()) {
            instance.solve();
        }
    }
}
