package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class SquareWords implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray();
        int[] cnt = new int[26];
        for (char c : s) {
            cnt[c - 'A']++;
        }
        int original = 0;
        for (int i = 0; i < 26; i++) {
            original += (cnt[i] * cnt[i]);
        }
        int max = original;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (i != j) {
                        max = max(max, original - (cnt[i] * cnt[i]) - (cnt[j] * cnt[j]) + (cnt[j] + cnt[i]) * (cnt[j] + cnt[i]));
                    }
                }
            }
        }
        out.println(max);
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
        try (SquareWords instance = new SquareWords()) {
            instance.solve();
        }
    }
}
