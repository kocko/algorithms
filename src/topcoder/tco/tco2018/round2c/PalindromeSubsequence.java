package topcoder.tco.tco2018.round2c;

public class PalindromeSubsequence {

    public int[] optimalPartition(String s) {
        int n = s.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        if (!isPalindrome(s)) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'b') {
                    result[i] = 2;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        boolean result = true;
        for (int i = 0; i < n / 2; i++) {
            result &= s.charAt(i) == s.charAt(n - i - 1);
        }
        return result;
    }

}
