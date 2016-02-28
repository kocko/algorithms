package hackerearth.codemonk.searching;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheOldMonk implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            long[] a = new long[n], b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nl();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nl();
            }
            out.println(findMonkiness(a, b));
        }
    }

    long findMonkiness(long[] a, long[] b) {
        long result = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int left = i, right = n - 1;
            int temp = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (b[mid] >= a[i]) {
                    temp = mid - i;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (temp > result) result = temp;
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
        new TheOldMonk().solve();
    }
}
