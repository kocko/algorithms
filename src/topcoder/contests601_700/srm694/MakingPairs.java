package topcoder.contests601_700.srm694;

public class MakingPairs {
	
	public int get(int[] card) {
		int result = 0;
        for (int c : card) {
            result += (c / 2);
        }
        return result;
	}
}
