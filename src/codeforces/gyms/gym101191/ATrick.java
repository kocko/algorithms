package codeforces.gyms.gym101191;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ATrick implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long x = in.nl();
        char[] s = String.valueOf(x).toCharArray();
        int n = s.length;
        if (n == 1 && s[0] == '0') {
            out.println(-1);
        } else {
            final long UP = (long) 1e9;
            if (x * 10 <= UP) {
                out.println(x * 10);
            } else {
                int sum = 0;
                for (char c : s) {
                    sum += (c - '0');
                }
                if (sum == 81) {
                    out.println(-1);
                } else if (sum > 72 && s[n - 1] != '9') {
                    out.println(x - 9);
                } else {
                    while (sum > 0) {
                        if (sum <= 9) {
                            out.print(sum);
                            sum = 0;
                        } else {
                            out.print(9);
                            sum -= 9;
                        }
                    }
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
        try (ATrick instance = new ATrick()) {
            instance.solve();
        }
    }
}
