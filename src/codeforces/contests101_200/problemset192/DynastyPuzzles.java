package codeforces.contests101_200.problemset192;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class DynastyPuzzles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] names = new String[n];
        int[][] dp = new int[26][26];
        for (int i = 0; i < n; i++) {
            names[i] = in.next();
            int size = names[i].length();
            int start = names[i].charAt(0) - 'a', end = names[i].charAt(size - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (dp[j][start] != 0) {
                    dp[j][end] = max(dp[j][end], size + dp[j][start]);
                }
            }
            dp[start][end] = max(dp[start][end], size);
        }
        int max = dp[0][0];
        for (int idx = 0; idx < 26; idx++) {
            max = max(max, dp[idx][idx]);
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
        try (DynastyPuzzles instance = new DynastyPuzzles()) {
            instance.solve();
        }
    }
}
