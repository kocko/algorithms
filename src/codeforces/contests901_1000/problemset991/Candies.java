package codeforces.contests901_1000.problemset991;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Candies implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), half = n / 2 + (n % 2);
        long left = 1, right = n, result = (long) 1e18 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (score(n, mid) >= half) {
                result = min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        out.println(result);
    }

    private long score(long n, long k) {
        long vasya = 0;
        while (n > 0) {
            if (n <= k) {
                vasya += n;
                break;
            } else {
                n -= k;
                vasya += k;
                if (n >= 10) n -= n / 10;
            }
        }
        return vasya;
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
        try (Candies instance = new Candies()) {
            instance.solve();
        }
    }
}
