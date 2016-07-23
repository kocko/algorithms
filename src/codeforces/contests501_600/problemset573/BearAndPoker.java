package codeforces.contests501_600.problemset573;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BearAndPoker implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int first = in.ni();
        Map<Integer, Integer> divisors = findDivisors(first);
        Set<Integer> cache = new HashSet<>();
        cache.add(first);
        for (int i = 1; i < n; i++) {
            int next = in.ni();
            if (!cache.contains(next)) {
                Map<Integer, Integer> d = findDivisors(next);
                if (!divisors.equals(d)) {
                    out.println("No");
                    return;
                }
                cache.add(next);
            }
        }
        out.println("Yes");
    }

    private Map<Integer, Integer> findDivisors(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                if (i != 2 && i != 3) {
                    result.put(i, result.getOrDefault(i, 0) + 1);
                }
                n /= i;
            }
        }
        if (n > 3) {
            result.put(n, 1);
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

    public static void main(String[] args) {
        new BearAndPoker().solve();
    }
}
