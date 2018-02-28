package uva.volume004;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PeriodicStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] x = in.next().toCharArray();
            int n = x.length;
            int[] fail = new int[n];
            for (int i = 1; i < n; i++) {
                fail[i] = fail[i - 1];
                while (fail[i] > 0 && x[fail[i]] != x[i]) {
                    fail[i] = fail[fail[i] - 1];
                }
                if (x[fail[i]] == x[i]) {
                    fail[i]++;
                }
            }
            int period = 0;
            for (int i = 1; i <= n; i++) {
                if (i - fail[i - 1] > period) {
                    period = i - fail[i - 1];
                }
            }
            if (n % period != 0) {
                period = n;
            }
            out.println(period);
            if (t > 0) {
                out.println();
            }
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
        try (PeriodicStrings instance = new PeriodicStrings()) {
            instance.solve();
        }
    }
}
