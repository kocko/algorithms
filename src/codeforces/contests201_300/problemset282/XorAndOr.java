package codeforces.contests201_300.problemset282;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XorAndOr implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        if (x.length != y.length) {
            out.println("NO");
            return;
        }
        boolean a = allZeroes(x), b = allZeroes(y);
        if (a ^ b) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }

    public boolean allZeroes(char[] x) {
        boolean ok = true;
        for (char c : x) {
            ok &= c == '0';
        }
        return ok;
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
        try (XorAndOr instance = new XorAndOr()) {
            instance.solve();
        }
    }
}
