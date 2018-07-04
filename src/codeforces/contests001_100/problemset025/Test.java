package codeforces.contests001_100.problemset025;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Test implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        powers = new long[100001];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (powers[i - 1] * BASE) % MOD;
        }
        String a = in.next(), b = in.next(), c = in.next();
        int min = get(a, b, c);
        min = min(min, get(a, c, b));
        min = min(min, get(b, a, c));
        min = min(min, get(b, c, a));
        min = min(min, get(c, a, b));
        min = min(min, get(c, b, a));
        out.println(min);
    }

    private int get(String a, String b, String c) {
        return min(merge(merge(a, b), c).length(), merge(a, merge(b, c)).length());
    }

    private String merge(String a, String b) {
        long[] hash_a = hash(a.toCharArray());
        long[] hash_b = hash(b.toCharArray());
        if (a.length() < b.length()) {
            if (isSubstring(hash_a, hash_b)) {
                return b;
            }
        } else {
            if (isSubstring(hash_b, hash_a)) {
                return a;
            }
        }
        int overlap = common(hash_a, hash_b);
        return a + b.substring(overlap);
    }

    private final long BASE = 27, MOD = (long) 1e9 + 7;
    private long[] powers;

    private long[] hash(char[] x) {
        long[] result = new long[x.length];
        result[0] = x[0] - 'a' + 1;
        for (int i = 1; i < x.length; i++) {
            long code = x[i] - 'a' + 1;
            result[i] = result[i - 1] * BASE + code;
            result[i] %= MOD;
        }
        return result;
    }

    private int common(long[] first, long[] second) {
        int n = first.length, m = second.length;
        int result = 0, idx = n - 1;
        while (idx >= 0) {
            int size = n - idx;
            if (size > m) size = m;
            if (hash(first, idx, idx + size - 1) == hash(second, 0, size - 1)) {
                result = size;
            }
            idx--;
        }
        return result;
    }

    private long hash(long[] hash, int start, int end) {
        long h1 = hash[end];
        long h2 = start > 0 ? hash[start - 1] * powers[end - start + 1] % MOD : 0;
        return (h1 - h2 + MOD) % MOD;
    }

    private boolean isSubstring(long[] a, long[] b) {
        int n = b.length, m = a.length;
        long hash = a[m - 1];
        for (int i = 0; i <= n - m; i++) {
            if (hash(b, i, i + m - 1) == hash) return true;
        }
        return false;
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
        try (Test instance = new Test()) {
            instance.solve();
        }
    }
}
