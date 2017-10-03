package codeforces.contests301_400.problemset373;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CollectingBeatsIsFun implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni();
        int[] cnt = new int[10];
        for (int i = 0; i < 4; i++) {
            char[] x = in.next().toCharArray();
            for (char c : x) {
                if (c != '.') cnt[c - '0']++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (cnt[i] > 2 * k) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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
        try (CollectingBeatsIsFun instance = new CollectingBeatsIsFun()) {
            instance.solve();
        }
    }
}
