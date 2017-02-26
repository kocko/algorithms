package codeforces.contests601_700.problemset670;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicPowder2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long magic = in.ni();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nl();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nl();
        }
        int left = 0, right = 2000000000;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (can(a, b, mid, magic)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        out.println(result);
    }

    private boolean can(long[] a, long[] b, long target, long magic) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] * target > b[i]) {
                magic -= a[i] * target - b[i];
            }
            if (magic < 0) {
                return false;
            }
        }
        return true;
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
        try (MagicPowder2 instance = new MagicPowder2()) {
            instance.solve();
        }
    }
}
