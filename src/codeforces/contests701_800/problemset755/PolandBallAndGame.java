package codeforces.contests701_800.problemset755;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PolandBallAndGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        Set<String> a = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(in.next());
        }
        Set<String> b = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String next = in.next();
            if (a.contains(next)) {
                common.add(next);
            }
            b.add(next);
        }
        boolean wins = false;
        if (common.size() % 2 == 0) {
            a.removeAll(common);
            b.removeAll(common);
            if (a.size() > b.size()) {
                wins = true;
            }
        } else {
            a.removeAll(common);
            b.removeAll(common);
            if (a.size() >= b.size()) {
                wins = true;
            }
        }
        out.println(wins ? "YES" : "NO");
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
        try (PolandBallAndGame instance = new PolandBallAndGame()) {
            instance.solve();
        }
    }
}
