package projecteuler;

import java.math.BigDecimal;

public class DigitFactorials {

	static int[] factorials = new int[10];
	
//	public static void main(String[] args) {
//		init();
//		for (int i : factorials) {
//			System.out.println(i);
//		}
////		System.out.println(findSum());
//	}
	
	static void init() {
		factorials[1] = 1;
		for (int i = 2; i < 10; i++) {
			factorials[i] = factorials[i - 1] * i;
		}
	}
	
//	static long findSum() {
//		for (int i = 10; )
//	}
	
	public static void main(String[] args) {
		Integer amountInCents = 1020;

        final BigDecimal HUNDRED = new BigDecimal("100");
        BigDecimal amount = new BigDecimal(amountInCents);

        System.out.println(amount.doubleValue());
	}
}
