package codeforces.contests501_600.problemset507;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessYourWayOut implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long h = in.nl(), n = in.nl();
        long leaves = (1L << h);
        long ans = 0;
        for (int level = 0; level < h; level++) {
            long half = (leaves >> 1);
            if (n > half) {
                if (ans % 2 == 0) {
                    ans += leaves;
                } else {
                    ans++;
                }
                n -= half;
            } else {
                if (ans % 2 == 1) {
                    ans += leaves;
                } else {
                    ans++;
                }
            }
            leaves >>= 1;
        }
        out.println(ans);
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
        try (GuessYourWayOut instance = new GuessYourWayOut()) {
            instance.solve();
        }
    }
}
