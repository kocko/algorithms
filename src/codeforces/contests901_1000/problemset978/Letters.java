package codeforces.contests901_1000.problemset978;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Letters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        long[] a = new long[n + 1], prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nl();
            prefix[i] = prefix[i - 1] + a[i];
        }
        while (q-- > 0) {
            long letter = in.nl();
            int left = 0, right = n;
            int dormitory = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] < letter) {
                    left = mid + 1;
                    dormitory = max(dormitory, mid);
                } else {
                    right = mid - 1;
                }
            }
            long room = letter - prefix[dormitory];
            out.println((dormitory + 1) + " " + room);
        }
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
        try (Letters instance = new Letters()) {
            instance.solve();
        }
    }
}
