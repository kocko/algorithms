package topcoder.contests601_700.srm609;

import static java.lang.Math.min;

public class PackingBallsDiv2 {

    public int minPacks(int r, int g, int b) {
        dp = new int[101][101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return recurse(r, g, b);
    }

    private final int oo = (int) 1e6 + 5;
    private int[][][] dp;

    private int recurse(int red, int green, int blue) {
        if (red < 0 || green < 0 || blue < 0) return oo;
        if (red == 0 && green == 0 && blue == 0) return 0;

        if (dp[red][green][blue] != -1) return dp[red][green][blue];

        int ans = oo;

        for (int i = 1; i <= 3; i++) {
            if (red >= i) ans = min(ans, 1 + recurse(red - i, green, blue));
            if (green >= i) ans = min(ans, 1 + recurse(red, green - i, blue));
            if (blue >= i) ans = min(ans, 1 + recurse(red, green, blue - i));
        }
        if (red >= 1 && green >= 1 && blue >= 1) ans = min(ans, 1 + recurse(red - 1, green - 1, blue - 1));
        if (red >= 1 && green >= 1) ans = min(ans, 1 + recurse(red - 1, green - 1, blue));
        if (red >= 1 && blue >= 1) ans = min(ans, 1 + recurse(red - 1, green, blue - 1));
        if (blue >= 1 && green >= 1) ans = min(ans, 1 + recurse(red, green - 1, blue - 1));

        return dp[red][green][blue] = ans;
    }

}
