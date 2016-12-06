package topcoder.tco.tco2016.round1;

public class ThreeProgrammers {

    public String validCodeHistory(String code) {
        char[] ch = code.toCharArray();
        n = ch.length;
        for (char x : ch) {
            if (x == 'A') a++;
            else if (x == 'B') b++;
            else if (x == 'C') c++;
        }
        this.dp = new boolean[a + 1][b + 1][c + 1][4][4];
        result = "impossible";
        recurse(0, 0, 0, 3, 3, "");
        return result;
    }

    private int a;
    private int b;
    private int c;
    private boolean[][][][][] dp;
    
    private String result;
    private boolean found;
    private int n;
    
    private void recurse(int a, int b, int c, int prev, int pprev, String s) {
        if (found) return;
        dp[a][b][c][prev][pprev] = true;
        int idx = a + b + c;
        if (idx == n) {
            result = s;
            found = true;
            return;
        }
        if (idx < n) {
            if (a < this.a && !dp[a + 1][b][c][0][prev]) {
                recurse(a + 1, b, c, 0, prev, s + "A");
            }
            if (b < this.b && prev != 1 && !dp[a][b + 1][c][1][prev]) {
                recurse(a, b + 1, c, 1, prev, s + "B");
            }
            if (c < this.c && prev != 2 && pprev != 2 && !dp[a][b][c + 1][2][prev]) {
                recurse(a, b, c + 1, 2, prev, s + "C");
            }
        }
    }

}
