package codeforces.contests801_900.problemset888;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MaximumSubsequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        long result = 0;
        int half = n / 2;
        int MAX = 1 << half;
        TreeSet<Integer> left = new TreeSet<>();
        for (int mask = 0; mask < MAX; mask++) {
            int sum = 0;
            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += x[i];
                    sum %= m;
                }
            }
            left.add(sum);
        }
        int rem = n - half;
        MAX = 1 << rem;
        for (int mask = 0; mask < MAX; mask++) {
            int sum = 0;
            for (int j = half; j < n; j++) {
                if ((mask & (1 << (j - half))) != 0) {
                    sum += x[j];
                    sum %= m;
                }
            }
            int ceil = m - sum;
            Integer p = left.lower(ceil);
            if (p != null) {
                result = Math.max(sum + p, result);
            }
        }
        out.println(result);
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
        try (MaximumSubsequence instance = new MaximumSubsequence()) {
            instance.solve();
        }
    }
}
