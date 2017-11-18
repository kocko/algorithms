package topcoder.contests701_800.srm723;

public class TopXorerEasy {

    public int maximalRating(int a, int b, int c) {
		int result = 0;
        for (int i = 30; i >= 0; i--) {
            int value = 1 << i;
            if (value <= a) {
                result |= value;
                a -= value;
            } else if (value <= b) {
                result |= value;
                b -= value;
            } else if (value <= c) {
                result |= value;
                c -= value;
            }
        }
        return result;
    }

}
