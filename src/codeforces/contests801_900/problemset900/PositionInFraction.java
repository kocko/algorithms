package codeforces.contests801_900.problemset900;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PositionInFraction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni(), c = in.ni();
        boolean[] used = new boolean[1000001];
        int idx = 0;
        while (true) {
            if (a < b) {
                a *= 10;
                idx++;
            }
            if (used[a]) {
                out.println(-1);
                return;
            }
            used[a] = true;
            int d = a / b, rem = a % b;
            if (c == d) {
                break;
            } else {
                a = rem;
            }
        }
        out.println(idx);
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
        try (PositionInFraction instance = new PositionInFraction()) {
            instance.solve();
        }
    }
}
