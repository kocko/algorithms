package codeforces.contests401_500.problemset469;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwentyFourGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n < 4) {
            out.println("NO");
        } else {
            out.println("YES");
            if (n % 2 == 1) {
                out.println("5 - 1 = 4");
                out.println("4 - 2 = 2");
            } else {
                out.println("1 * 2 = 2");
            }
            out.println("3 * 4 = 12");
            out.println("2 * 12 = 24");
            while (n > 5) {
                out.printf("%d - %d = 1\n24 * 1 = 24\n", n--, n--);
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
        try (TwentyFourGame instance = new TwentyFourGame()) {
            instance.solve();
        }
    }
}
