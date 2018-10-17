package codeforces.contests1001_1100.problemset1066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class BoxesPacking implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long m = in.nl(), k = in.nl();
        long[] a = new long[n];
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nl();
            prefix[i + 1] = prefix[i] + a[i];
        }

        int left = 0, right = n, result = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (can(prefix, mid, a, m, k)) {
                result = min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        out.println(n - result);
    }

    private boolean can(long[] prefix, int first, long[] a, long m, long k) {
        int n = a.length;
        if (prefix[n] - prefix[first] > m * k) {
            return false;
        }
        long boxes = 0, current = 0;
        for (int i = first; i < n; i++) {
            if (current + a[i] <= k) {
                current += a[i];
            } else {
                boxes++;
                current = a[i];
            }
        }
        return boxes < m;
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
        try (BoxesPacking instance = new BoxesPacking()) {
            instance.solve();
        }
    }
}
