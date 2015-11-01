package projecteuler;

public class IntegerRightTriangles {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(calculate());
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}

	static int calculate() {
		int max = 0;
		int result = 0;
		for (int p = 120; p < 1000; p++) {
			int count = 0;
			for (int a = 1; a < (p - 2) / 2; a++) {
				for (int b = a; b < (p - 1) / 2; b++) {
					int c = p - a - b;
					if (a * a + b * b == c * c) {
						count++;
					}
				}
			}
			if (count > max) {
				max = Math.max(max, count);
				result = p;
			}
		}
		return result;
	}

}
