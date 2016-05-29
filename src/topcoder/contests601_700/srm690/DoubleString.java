package topcoder.contests601_700.srm690;

public class DoubleString {

    public String check(String s) {
        char[] x = s.toCharArray();
        if (x.length % 2 == 1) {
            return "not square";
        } else {
            boolean ok = true;
            int n = x.length / 2;
            for (int i = 0; i < n; i++) {
                if (x[i] != x[n + i]) {
                    ok = false;
                    break;
                }
            }
            return ok ? "square" : "not square";
        }
    }
    
}