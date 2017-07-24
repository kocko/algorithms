package uva.volume101;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String next;
        int test = 1;
        while (!"#".equals(next = in.nextLine())) {
            a = next.toCharArray();
            b = in.nextLine().toCharArray();
            int n = a.length, m = b.length;
            dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = recurse(n - 1, m - 1);
            out.printf("Case #%d: you can visit at most %d cities.\n", test++, ans);
        }
    }
    
    private char[] a, b;
    private int[][] dp;
    
    private int recurse(int i, int j) {
        if (i < 0 || j < 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int ans;
        if (a[i] == b[j]) {
            ans = 1 + recurse(i - 1, j - 1);
        } else {
            ans = Math.max(recurse(i - 1, j), recurse(i, j - 1));
        }
        return dp[i][j] = ans;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
