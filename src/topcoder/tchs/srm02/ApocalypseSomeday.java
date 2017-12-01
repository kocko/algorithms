package topcoder.tchs.srm02;

public class ApocalypseSomeday {
	
	public int getNth(int n) {
		int i = 666;
		for (;;i++) {
			if (Integer.toString(i).contains("666")) {
				if (n-- == 1) {
					return i;
				}
			}
		}
	}
	
}
