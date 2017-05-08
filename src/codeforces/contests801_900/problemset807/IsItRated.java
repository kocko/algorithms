package codeforces.contests801_900.problemset807;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IsItRated implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        boolean changed = false, sorted = true;
        int lastBefore = 5000, lastNow = 5000;
        for (int i = 0; i < n; i++) {
            int before = in.ni(), now = in.ni();
            sorted &= (before <= lastBefore && now <= lastNow);
            changed |= (before != now);
            lastBefore = before;
            lastNow = now;
        }
        if (changed) {
            out.println("rated");
        } else {
            out.println(sorted ? "maybe" : "unrated");
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
        try (IsItRated instance = new IsItRated()) {
            instance.solve();
        }
    }
}
