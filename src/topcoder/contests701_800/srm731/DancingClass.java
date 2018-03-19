package topcoder.contests701_800.srm731;

public class DancingClass {

    public String checkOdds(int n, int k) {
        if (n > 55) {
            return "High";
        }
        long[][] c = new long[70][70];
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < i; j++) {
                if (j > 0) {
                    c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                } else {
                    c[i][j] = 1L;
                }
            }
        }
        long s1 = 0, s2 = 0;
        for (int i = 0; i <= n; i++) {
            if (i * (n - i) >= k) {
                s1 += c[n][i];
            } else {
                s2 += c[n][i];
            }
        }
        if (s1 == s2) {
            return "Equal";
        } else if (s1 < s2) {
            return "Low";
        }
        return "High";
    }
    
}
