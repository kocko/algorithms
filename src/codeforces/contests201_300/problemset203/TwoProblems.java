package codeforces.contests201_300.problemset203;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TwoProblems implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), t = in.ni(), a = in.ni(), b = in.ni(), da = in.ni(), db = in.ni();
        boolean[] can_a = new boolean[601];
        boolean[] can_b = new boolean[601];
        can_a[0] = true;
        can_b[0] = true;
        for (int i = 0; i < t; i++) {
            int first = a - da * i, second = b - db * i;
            if (first >= 0) {
                can_a[first] = true;
            }
            if (second >= 0) {
                can_b[second] = true;
            }
        }
        for (int i = 0; i <= x; i++) {
            if (can_a[i] && x - i >= 0 && can_b[x - i]) {
                out.println("YES");
                return;
            }
            if (can_b[i] && x - i >= 0 && can_a[x - i]) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
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
        try (TwoProblems instance = new TwoProblems()) {
            instance.solve();
        }
    }
}
