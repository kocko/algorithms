package topcoder.contests601_700.srm609;

public class VocaloidsAndSongs {

    public int count(int s, int gumi, int ia, int mayu) {
        this.s = s;
        dp = new int[50][50][50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 50; k++) {
                    for (int l = 0; l < 50; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return recurse(0, gumi, ia, mayu);
    }

    private int s;
    private final int MOD = (int) 1e9 + 7;
    private int[][][][] dp;

    private int recurse(int idx, int gumi, int ia, int mayu) {
        if (idx == s) return (gumi == 0 && ia == 0 && mayu == 0) ? 1 : 0;
        if (dp[idx][gumi][ia][mayu] != -1) return dp[idx][gumi][ia][mayu];

        int ans = 0;
        if (gumi > 0) {
            ans += recurse(idx + 1, gumi - 1, ia, mayu);
            ans %= MOD;
        }
        if (ia > 0) {
            ans += recurse(idx + 1, gumi, ia - 1, mayu);
            ans %= MOD;
        }
        if (mayu > 0) {
            ans += recurse(idx + 1, gumi, ia, mayu - 1);
            ans %= MOD;
        }
        if (gumi > 0 && ia > 0) {
            ans += recurse(idx + 1, gumi - 1, ia - 1, mayu);
            ans %= MOD;
        }
        if (gumi > 0 && mayu > 0) {
            ans += recurse(idx + 1, gumi - 1, ia, mayu - 1);
            ans %= MOD;
        }
        if (mayu > 0 && ia > 0) {
            ans += recurse(idx + 1, gumi, ia - 1, mayu - 1);
            ans %= MOD;
        }
        if (gumi > 0 && ia > 0 && mayu > 0) {
            ans += recurse(idx + 1, gumi - 1, ia - 1, mayu - 1);
            ans %= MOD;
        }

        return dp[idx][gumi][ia][mayu] = ans;
    }

}
