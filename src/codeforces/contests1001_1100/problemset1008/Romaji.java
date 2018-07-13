package codeforces.contests1001_1100.problemset1008;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Romaji implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        boolean ok = true;
        for (int i = 0; i < n - 1; i++) {
            if (!isVowel(x[i])) {
                if (x[i] != 'n') {
                    ok &= isVowel(x[i + 1]);
                }
            }
        }
        ok &= x[n - 1] == 'n' || isVowel(x[n - 1]);
        out.println(ok ? "YES" : "NO");
    }

    private boolean isVowel(char c) {
        return "aouie".indexOf(c) >= 0;
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
        try (Romaji instance = new Romaji()) {
            instance.solve();
        }
    }
}
