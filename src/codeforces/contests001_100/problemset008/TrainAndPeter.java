package codeforces.contests001_100.problemset008;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TrainAndPeter implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), a = in.next().toCharArray(), b = in.next().toCharArray();
        char[] reverse = new char[x.length];
        for (int i = 0; i < x.length; i++) {
            reverse[i] = x[x.length - i - 1];
        }
        
        int code = 0;
        if (check(x, a, b)) code |= 1;
        if (check(reverse, a, b)) code |= 2;
        
        if (code == 0) {
            out.println("fantasy");
        } else if (code == 1) {
            out.println("forward");
        } else if (code == 2) {
            out.println("backward");
        } else if (code == 3) {
            out.println("both");
        }
    }

    private boolean check(char[] x, char[] a, char[] b) {
        final int n = x.length;
        final long MOD = (long) 1e9 + 7, BASE = 27;
        long[] hash = new long[n];
        hash[0] = x[0] - 'a' + 1;
        for (int i = 1; i < n; i++) {
            int code = x[i] - 'a' + 1;
            hash[i] = hash[i - 1] * BASE + code;
            hash[i] %= MOD;
        }

        long first = a[0] - 'a' + 1;
        for (int i = 1; i < a.length; i++) {
            int code = a[i] - 'a' + 1;
            first = (first * BASE + code);
            first %= MOD;
        }
        long second = b[0] - 'a' + 1;
        for (int i = 1; i < b.length; i++) {
            int code = b[i] - 'a' + 1;
            second = (second * BASE + code);
            second %= MOD;
        }

        long[] powers = new long[n + 1];
        powers[0] = 1;
        for (int i = 1; i <= n; i++) {
            powers[i] = powers[i - 1] * BASE;
            powers[i] %= MOD;
        }

        boolean foundA = false;
        int size = a.length, pos = size - 1;
        while (pos < n) {
            long h1 = hash[pos];
            long h2 = pos - size >= 0 ? hash[pos - size] : 0;
            h2 = (h2 * powers[size]) % MOD;

            long h = (h1 - h2 + MOD) % MOD;

            if (h == first) {
                foundA = true;
                break;
            }
            pos++;
        }
        size = b.length;
        pos += size;
        boolean foundB = false;
        while (pos < n) {
            long h1 = hash[pos];
            long h2 = pos - size >= 0 ? hash[pos - size] : 0;
            h2 = (h2 * powers[size]) % MOD;

            long h = (h1 - h2 + MOD) % MOD;

            if (h == second) {
                foundB = true;
                break;
            }
            pos++;
        }
        
        return foundA && foundB;
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
        try (TrainAndPeter instance = new TrainAndPeter()) {
            instance.solve();
        }
    }
}
