package topcoder.contests601_700.srm609;

public class MagicalStringDiv2 {

    public int minimalMoves(String s) {
        char[] x = s.toCharArray();
        int result = 0, n = x.length, half = n / 2;
        for (int i = 0; i < half; i++) {
            if (x[i] != '>') result++;
            if (x[i + half] != '<') result++;
        }
        return result;
    }

}
