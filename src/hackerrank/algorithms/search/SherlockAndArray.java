package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SherlockAndArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        test: while (t-- > 0) {
            int n = in.ni();
            if (n == 1) {
                in.ni();
                out.println("YES");
                continue;
            }
            int[] list = new int[n];
            int[] prefix = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = in.ni();
                if (i == 0) {
                    prefix[0] = list[0];
                } else {
                    prefix[i] = list[i] + prefix[i - 1];
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) {
                    if (prefix[n - 1] == 0) {
                        out.println("YES");
                        continue test;
                    }
                } else {
                    if (prefix[i - 1] == (prefix[n - 1] - prefix[i])) {
                        out.println("YES");
                        continue test;
                    }
                }
            }
            out.println("NO");
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

    public static void main(String[] args) {
        new SherlockAndArray().solve();
    }
}
