package codeforces.contests701_800.problemset798;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeAndPalindrome implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int limit = n / 2 - (n % 2 == 0 ? 1 : 0);
        int diff = 0;
        for (int i = 0; i <= limit; i++) {
            diff += (x[i] == x[n - i - 1] ? 0 : 1);
        }
        if (diff == 0) {
            out.println(n % 2 == 1 ? "YES" : "NO");
        } else if (diff > 1) {
            out.println("NO");
        } else {
            out.println("YES");
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
        try (MikeAndPalindrome instance = new MikeAndPalindrome()) {
            instance.solve();
        }
    }
}
