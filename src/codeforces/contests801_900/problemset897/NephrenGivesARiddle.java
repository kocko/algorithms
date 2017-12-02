package codeforces.contests801_900.problemset897;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class NephrenGivesARiddle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        size[0] = a.length;
        for (int i = 1; i < size.length; i++) {
            size[i] = s[1] + s[2] + s[3] + 2L * size[i - 1];
            size[i] = min(size[i], (long) 2e18);
        }
        int q = in.ni();
        while (q-- > 0) {
            int n = in.ni();
            long k = in.nl();
            out.print(recurse(n, k));
        }
    }

    private long[] size = new long[1 << 20];
    private final char[] a = "What are you doing at the end of the world? Are you busy? Will you save us?".toCharArray();
    private final char[] b = "What are you doing while sending \"".toCharArray();
    private final char[] c = "\"? Are you busy? Will you send \"".toCharArray();
    private final char[] d = "\"?".toCharArray();
    private long[] s = {(long) a.length, (long) b.length, (long) c.length, (long) d.length};

    private char recurse(int n, long k) {
        if (k > size[n]) return '.';
        if (n == 0) return a[(int) k - 1];
        
        if (k <= s[1]) return b[(int) k - 1];
        if (k <= s[1] + size[n - 1]) return recurse(n - 1, k - s[1]);
        if (k <= s[1] + size[n - 1] + s[2]) return c[(int) (k - s[1] - size[n - 1] - 1)];
        if (k <= s[1] + size[n - 1] + s[2] + size[n - 1]) return recurse(n - 1, k - s[1] - size[n - 1] - s[2]);
        return d[(int) (k - s[1] - 2L * size[n - 1] - s[2] - 1)];
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
        try (NephrenGivesARiddle instance = new NephrenGivesARiddle()) {
            instance.solve();
        }
    }
}
