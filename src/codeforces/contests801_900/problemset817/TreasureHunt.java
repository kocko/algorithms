package codeforces.contests801_900.problemset817;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class TreasureHunt implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
        int x = in.ni(), y = in.ni();
        int a = abs(x1 - x2), b = abs(y1 - y2);
        boolean ok = (a % x == 0) && (b % y == 0) && ((a / x) % 2 == (b / y) % 2);
        out.println(ok ? "YES" : "NO");
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
        try (TreasureHunt instance = new TreasureHunt()) {
            instance.solve();
        }
    }
}
