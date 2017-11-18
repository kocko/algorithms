package csadademy.problemset057;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConcatenatedArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        int zeroes = 0;
        for (char c : x) {
            if (c == '0') zeroes++;
        }
        if (zeroes == n) {
            out.println(((long) n) * k);
        } else {
            int current = 0, max = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (x[i] == '0') {
                    current++;
                } else {
                    max = Math.max(max, current);
                    current = 0;
                }
            }
            max = Math.max(max, current);
            int left = 0, right = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] == '1') break;
                else left++;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (x[i] == '1') break;
                else right++;
            }
            if (k > 1) {
                out.println(Math.max(left + right, max));
            } else {
                out.println(max);
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
        try (ConcatenatedArray instance = new ConcatenatedArray()) {
            instance.solve();
        }
    }
}
