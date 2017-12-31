package codeforces.contests501_600.problemset548;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeAndFax implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        int k = in.ni(), n = s.length(), size = n / k;
        if (k * size != n) {
            out.println("NO");
            return;
        }
        boolean ok = true;
        for (int i = 0; i < n; i += size) {
            ok &= isPalindrome(s.substring(i, i + size));
        }
        out.println(ok ? "YES" : "NO");
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        boolean result = true;
        for (int i = 0; i < n / 2; i++) {
            result &= s.charAt(i) == s.charAt(n - i - 1);
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

    public static void main(String[] args) throws IOException {
        try (MikeAndFax instance = new MikeAndFax()) {
            instance.solve();
        }
    }
}
