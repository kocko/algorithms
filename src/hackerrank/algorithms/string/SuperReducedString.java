package hackerrank.algorithms.string;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SuperReducedString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        while (true) {
            int n = s.length();
            boolean deleted = false;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    deleted = true;
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    break;
                }
            }
            if (!deleted) break;
        }
        out.println("".equals(s) ? "Empty String" : s);
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
        try (SuperReducedString instance = new SuperReducedString()) {
            instance.solve();
        }
    }
}
