package codeforces.contests1001_1100.problemset1082;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class VasyaAndBook implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), x = in.ni(), y = in.ni(), d = in.ni();
            int dist = abs(x - y);
            if (dist % d == 0) {
                out.println(dist / d);
            } else {
                int p, q;
                p = x / d + (x % d != 0 ? 1 : 0);
                int d1 = y - 1;
                if (d1 % d == 0) {
                    p += d1 / d;
                } else {
                    p = Integer.MAX_VALUE;
                }
                q = (n - x) / d + ((n - x) % d != 0 ? 1 : 0);
                int d2 = n - y;
                if (d2 % d == 0) {
                    q += (d2 / d);
                } else {
                    q = Integer.MAX_VALUE;
                }
                int result = Math.min(p, q);
                if (result == Integer.MAX_VALUE) {
                    out.println(-1);
                } else {
                    out.println(result);
                }
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
        try (VasyaAndBook instance = new VasyaAndBook()) {
            instance.solve();
        }
    }
}
