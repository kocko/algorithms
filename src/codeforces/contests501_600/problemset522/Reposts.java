package codeforces.contests501_600.problemset522;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reposts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, Integer> reposts = new HashMap<>();
		reposts.put("polycarp", 1);
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split("\\s+");
			String author = line[2].toLowerCase();
			String repost = line[0].toLowerCase();
			if (reposts.containsKey(author)) {
				reposts.put(repost, reposts.get(author) + 1);
			}
		}
		sc.close();
		System.out.println(reposts.entrySet().stream().mapToInt(Map.Entry::getValue).max().getAsInt());
	}

}
