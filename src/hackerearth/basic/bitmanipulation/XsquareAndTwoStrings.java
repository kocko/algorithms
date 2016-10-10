package hackerearth.basic.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XsquareAndTwoStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            boolean[] m = new boolean[26];
            for (char c : a) {
                m[c - 'a'] = true;
            }
            boolean[] n = new boolean[26];
            for (char c : b) {
                n[c - 'a'] = true;
            }
            boolean result = false;
            for (int i = 0; i < 26; i++) {
                if (m[i] && n[i]) {
                    result = true;
                    break;
                }
            }
            out.println(result ? "Yes" : "No");
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
        try (XsquareAndTwoStrings instance = new XsquareAndTwoStrings()) {
            instance.solve();
        }
    }
}
