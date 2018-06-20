package codeforces.contests301_400.problemset335;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Palindrome implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        x = in.next().toCharArray();
        n = x.length;
        if (n >= 2575) {
            int[] cnt = new int[26];
            char letter = '?';
            for (char c : x) {
                cnt[c - 'a']++;
                if (cnt[c - 'a'] == 100) {
                    letter = c;
                    break;
                }
            }
            for (int i = 0; i < 100; i++) {
                out.print(letter);
            }
        } else {
            dp = new int[n][n];
            for (int i = 0; i < n; i++) fill(dp[i], -1);
            int max = recurse(0, n - 1);
            result = new char[max];
            restore(0, n - 1);
            if (idx <= 100) {
                for (char c : result) {
                    out.print(c);
                }
            } else {
                for (int i = 0; i < 50; i++) out.print(result[i]);
                for (int i = idx - 50; i < idx; i++) out.print(result[i]);
            }
        }
    }

    private int n, idx;
    private char[] x, result;
    private int[][] dp;

    private int recurse(int left, int right) {
        if (left > right) return 0;
        if (left == right) return 1;

        if (dp[left][right] != -1) return dp[left][right];

        int ans;
        if (x[left] == x[right]) {
            ans = 2 + recurse(left + 1, right - 1);
        } else {
            ans = max(recurse(left + 1, right), recurse(left, right - 1));
        }

        return dp[left][right] = ans;
    }

    private void restore(int left, int right) {
        if (left > right) return;
        if (left == right) result[idx++] = x[left];
        else if (x[left] == x[right]) {
            result[idx++] = x[left];
            restore(left + 1, right - 1);
            result[idx++] = x[right];
        } else {
            if (dp[left + 1][right] < dp[left][right - 1]) restore(left, right - 1);
            else restore(left + 1, right);
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
        try (Palindrome instance = new Palindrome()) {
            instance.solve();
        }
    }
}
