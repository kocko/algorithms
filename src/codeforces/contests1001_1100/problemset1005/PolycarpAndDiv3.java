package codeforces.contests1001_1100.problemset1005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PolycarpAndDiv3 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        x = in.next().toCharArray();
        n = x.length;
        dp = new Integer[n][3];
        out.println(recurse(0, 0));
    }

    private int n;
    private char[] x;
    private Integer[][] dp;

    private int recurse(int idx, int remainder) {
        if (idx == n) return 0;
        if (dp[idx][remainder] != null) return dp[idx][remainder];

        int result;
        int next = (x[idx] - '0' + remainder) % 3;
        if (next == 0) {
            result = 1 + recurse(idx + 1, 0);
        } else {
            result = Math.max(recurse(idx + 1, 0), recurse(idx + 1, next));
        }
        return dp[idx][remainder] = result;
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
        try (PolycarpAndDiv3 instance = new PolycarpAndDiv3()) {
            instance.solve();
        }
    }
}
