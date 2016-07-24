package topcoder.contests101_200.srm191;

public class BettingMoney {
	
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
		int total = 0;
        for (int i = 0; i < amounts.length; i++) {
            if (i != finalResult) {
                total += amounts[i];
            }
        }
        total *= 100;
        return total - (amounts[finalResult] * centsPerDollar[finalResult]);
	}
}
