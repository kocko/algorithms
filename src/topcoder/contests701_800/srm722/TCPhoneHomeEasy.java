package topcoder.contests701_800.srm722;

public class TCPhoneHomeEasy {
	
	public int validNumbers(int digits, String[] specialPrefixes) {
		int max = 1;
		for (int i = 0; i < digits; i++) max *= 10;
		for (String prefix : specialPrefixes) {
			int size = prefix.length(), rem = digits - size;
			int remove = 1;
			for (int i = 0; i < rem; i++) {
				remove *= 10;
			}
			max -= remove;
		}
		return max;
	}
}
