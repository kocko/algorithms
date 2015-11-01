package projecteuler;

public class ReciprocalCycles {

	public static void main(String[] args) {
		int result = calculateMax();
		System.out.println(result);
	}
	
	static int calculateMax() {
		int max = 0;
		int result = 0;
		for (int i = 2; i < 999; i++) {
			int count = 0;
			int start = 1;
			boolean[] used = new boolean[9991];
			while (start != 0) {
				while (start < i) start *= 10;
				
				if (used[start]) break;
				
				used[start] = true;
				start = start % i;
				count++;
			}
			if (count > max) {
				max = count;
				result = i;
			}
		}
		return result;
	}
}
