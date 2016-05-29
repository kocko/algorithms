package topcoder.contests601_700.srm680;

public class BearPair {

    public int bigDistance(String s) {
        char[] x = s.toCharArray();
        int n = x.length;
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] != x[j]) result = Math.max(result, j - i);
            }
        }
        return result;
    }
    
}
