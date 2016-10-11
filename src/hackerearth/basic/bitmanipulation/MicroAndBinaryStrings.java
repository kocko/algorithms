package hackerearth.basic.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MicroAndBinaryStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            char[] s = in.next().toCharArray();
            if (n <= s.length) {
                int result = 0;
                for (int i = 0; i < n; i++) {
                    if (s[s.length - i - 1] == '1') result++;
                }
                out.println(result);
            } else {
                int total = 0;
                for (char c : s) {
                    if (c == '1') total++;
                }
                int result = total * (n / s.length);
                int rem = n % total;
                for (int i = 0; i < rem; i++) {
                    if (s[s.length - i - 1] == '1') result++;
                }
                out.println(result);
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
        try (MicroAndBinaryStrings instance = new MicroAndBinaryStrings()) {
            instance.solve();
        }
    }
}
