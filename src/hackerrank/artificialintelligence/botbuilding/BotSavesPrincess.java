package hackerrank.artificialintelligence.botbuilding;

import java.util.Scanner;

public class BotSavesPrincess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		boolean up = false, down = false, left = false, right = false;
		for (int i = 0; i < n; i++) {
			String nextLine = sc.nextLine();
			char[] split = nextLine.toCharArray();
			for (int j = 0; j < n; j++) {
				if (split[j] == 'p') {
					up = i == 0;
					down = i == n - 1;
					left = j == 0;
					right = j == n - 1;
				}
			}
		}
		if (up && left) {
			print((n + 1) / 2, "UP", "LEFT");
		} else if (up && right) {
			print((n + 1) / 2, "UP", "RIGHT");
		} else if (down && left) {
			print((n + 1) / 2, "DOWN", "LEFT");
		} else if (down && right) {
			print((n + 1) / 2, "DOWN", "RIGHT");
		}
		sc.close();
	}

	static void print(int times, String direction1, String direction2) {
		for (int i = 0; i < times - 1; i++) {
			System.out.println(direction1);
			System.out.println(direction2);
		}
	}
}
