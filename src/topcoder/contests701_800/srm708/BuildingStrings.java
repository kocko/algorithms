package topcoder.contests701_800.srm708;

import java.util.ArrayList;
import java.util.List;

public class BuildingStrings {

	public String[] findAny(int k) {
		List<String> result = new ArrayList<>();
		int currentScore = 0;
		while (currentScore < k) {
			out: for (int size = 50; size >= 1; size--) {
				for (int different = 26; different >= 1; different--) {
					if (different <= size) {
						if (currentScore + size * different <= k) {
							result.add(generate(size, different));
							currentScore += size * different;
							break out;
						}
					}
				}
			}
		}
		return result.toArray(new String[0]);
	}

	private String generate(int size, int different) {
		char[] result = new char[size];
		for (int i = size - 1; i >= 0; i--) {
			result[i] = (char) ('a' + (i % different));
		}
		return new String(result);
	}

}
