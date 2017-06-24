package uva.volume111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class LongestPalindrome implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = Integer.parseInt(in.nextLine());
        while (t-- > 0) {
            x = in.nextLine().toCharArray();
            int n = x.length;
            if (n == 0) {
                out.println(0);
                continue;
            }
            dp = new int[n][n];
            out.println(recurse(0, n - 1));
        }
    }

    private char[] x;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        if (i > j) return 0;
        else if (i == j) return 1;

        int ans;
        if (x[i] == x[j]) {
            ans = 2 + recurse(i + 1, j - 1);
        } else {
            ans = max(recurse(i + 1, j), recurse(i, j - 1));
        }

        return dp[i][j] = ans;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (LongestPalindrome instance = new LongestPalindrome()) {
            instance.solve();
        }
    }
}
