package topcoder.contests201_300.srm227;

public class StringCompare {

    public int simpleDifference(String a, String b) {
        int min = Math.min(a.length(), b.length());
        int res = 0;
        for (int i = 0; i < min; i++) {
            res += (a.charAt(i) == b.charAt(i)) ? 1 : 0;
        }
        return res;
    }
    
}
