package uva.volume107;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BarCodes implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            n = in.nextInt();
            k = in.nextInt();
            m = in.nextInt();
            dp = new Long[n][2][m + 1][k + 1];
            out.println(recurse(1, 1, 1, 1));
        }
    }

    private int n, m, k;

    private Long[][][][] dp;

    private long recurse(int idx, int color, int size, int bars) {
        if (idx == n) return bars == k ? 1 : 0;
        if (bars > k) return 0;
        if (dp[idx][color][size][bars] != null) return dp[idx][color][size][bars];

        long ans = 0;
        if (bars < k) {
            ans += recurse(idx + 1, color ^ 1, 1, bars + 1);
        }
        if (size + 1 <= m) {
            ans += recurse(idx + 1, color, size + 1, bars);
        }
        return dp[idx][color][size][bars] = ans;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (BarCodes instance = new BarCodes()) {
            instance.solve();
        }
    }
}
