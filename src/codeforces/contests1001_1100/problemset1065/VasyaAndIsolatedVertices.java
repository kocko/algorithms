package codeforces.contests1001_1100.problemset1065;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaAndIsolatedVertices implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), m = in.nl(), min, max;
        long left = 0, right = m, mx = left;
        while (left <= right) {
            long mid = (left + right) / 2;
            long edges = mid * (mid - 1) / 2;
            if (edges > m) {
                right = mid - 1;
            } else {
                mx = Math.max(mx, mid);
                left = mid + 1;
            }
        }
        max = n - mx;
        long remaining = m - (mx * (mx - 1) / 2);
        if (remaining > 0) {
            max--;
        }
        min = n - Math.min(2 * m, n);
        out.println(min + " " + max);
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
        try (VasyaAndIsolatedVertices instance = new VasyaAndIsolatedVertices()) {
            instance.solve();
        }
    }
}
