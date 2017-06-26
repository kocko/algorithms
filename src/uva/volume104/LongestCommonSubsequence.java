package uva.volume104;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while(in.hasNextLine()) {
            a = in.nextLine().toCharArray();
            b = in.nextLine().toCharArray();
            int n = a.length, m = b.length;
            dp = new int[n + 1][m + 1];
            for (int[] row : dp) Arrays.fill(row, -1);
            out.println(recurse(n, m));
        }
    }
    
    private char[] a, b;
    private int[][] dp;
    
    private int recurse(int n, int m) {
        if (n == 0 || m == 0) return 0;
        
        if (dp[n][m] != -1) return dp[n][m];
        
        if (a[n - 1] == b[m - 1]) {
            return dp[n][m] = 1 + recurse(n - 1, m - 1);
        } else {
            return dp[n][m] = Math.max(recurse(n - 1, m), recurse(n, m - 1));
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (LongestCommonSubsequence instance = new LongestCommonSubsequence()) {
            instance.solve();
        }
    }
}
