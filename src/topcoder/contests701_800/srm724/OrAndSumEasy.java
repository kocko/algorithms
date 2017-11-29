package topcoder.contests701_800.srm724;

public class OrAndSumEasy {

    public String isPossible(long or, long sum) {
        long and = sum - or;
        for (int i = 0; i < 64; i++) {
            long bit = 1L << i;
            if ((and & bit) != 0 && (or & bit) == 0) {
                return "Impossible";
            }
        }
        return "Possible";
    }
    
}
