package hackerrank.algorithms.bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		BigInteger[] numbers = new BigInteger[testCases];
		for (int i = 0; i < testCases; i++) {
			numbers[i] = new BigInteger(sc.nextLine());
		}
		
		for (BigInteger bi : numbers) {
			System.out.println(findWinner(bi));
		}
		sc.close();
	}
	
	static String findWinner(BigInteger i) {
		boolean richardWins = true;
		final BigInteger MINUS_ONE = new BigInteger("-1");
		while (!BigInteger.ONE.equals(i)) {
			String binary = i.toString(2);
			if (binary.matches("^1[0]+$")) {
				i = i.shiftRight(1);
			} else {
				i = i.add(findClosestPowerOfTwo(binary).multiply(MINUS_ONE));
			}
			richardWins = !richardWins;
		}
		return richardWins ? "Richard" : "Louise";
	}
	
	static BigInteger findClosestPowerOfTwo(String n) {
		int length = n.length() - 1;
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < length; i++) {
			result = result.shiftLeft(1);
		}
		return result;
	}
}
