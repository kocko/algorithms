package topcoder.contests201_300.srm232;

public class BritishCoins {
	
	public int[] coins(int pence) {
		int[] result = new int[3];
        result[0] = pence / 240;
        pence %= 240;
        result[1] = pence / 12;
        pence %= 12;
        result[2] = pence;
        return result;
	}
    
}
