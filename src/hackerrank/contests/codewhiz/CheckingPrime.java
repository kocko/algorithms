package hackerrank.contests.codewhiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CheckingPrime {

	static class Prime {
		static void checkPrime(int... list) {
			for (int i : list) {
				if (isPrime(i))
					System.out.print(i + " ");
			}
			System.out.println();
		}

		private static boolean isPrime(int num) {
			if (num == 2)
				return true;
			if (num % 2 == 0)
				return false;
			for (int i = 3; i * i <= num; i += 2)
				if (num % i == 0)
					return false;
			return true;
		}
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Random rand = new Random();
			int n = rand.nextInt();
			Prime ob = new Prime();
			Prime.checkPrime(1, 7, 4);
			Prime.checkPrime(9, 10, 32, 89, 66);
			Prime.checkPrime(19, 78, 98, 100, 787, 8989, 12817, 11, 192);
			Prime.checkPrime(90, 2, 31, 890, 8278, 87892, 12, 10);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
