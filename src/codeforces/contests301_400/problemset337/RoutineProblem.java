package codeforces.contests301_400.problemset337;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoutineProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni(), c = in.ni(), d = in.ni();
        if (a * d == b * c) {
            out.println("0/1");
        } else if (a * d < b * c) {
            int x = b * c - a * d, y = b * c, gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            out.printf("%d/%d\n", x, y);
        } else {
            int x = a * d - b * c, y = a * d, gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            out.printf("%d/%d\n", x, y);
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
        try (RoutineProblem instance = new RoutineProblem()) {
            instance.solve();
        }
    }
}
