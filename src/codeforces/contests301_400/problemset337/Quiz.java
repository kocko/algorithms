package codeforces.contests301_400.problemset337;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Quiz implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.ni(), correct = in.ni(), k = in.ni();
        long wrong = n - correct;
        long score = 0;
        if (correct < k) {
            score = correct;
        } else {
            long groups = correct / (k - 1), rem = correct % (k - 1);
            if (wrong >= groups + 1) {
                score += groups * (k - 1);
                score += rem;
                score %= MOD;
            } else {
                groups -= wrong;
                score += wrong * (k - 1);
                score %= MOD;
                rem = groups * (k - 1) + rem;
                long terms = rem / k, ones = rem % k;
                score += ones;
                score += (power(terms) - 1) * 2 * k;
            }
        }
        out.println(score % MOD);
    }
    
    private final long MOD = (long) 1e9 + 9;
    
    private long power(long p) {
        if (p == 0) return 1L;
        if (p % 2 == 1) {
            return 2L * power(p - 1) % MOD;
        }
        long x = power(p >> 1) % MOD;
        return (x * x) % MOD;
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
        try (Quiz instance = new Quiz()) {
            instance.solve();
        }
    }
}
