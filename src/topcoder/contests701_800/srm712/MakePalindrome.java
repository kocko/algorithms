package topcoder.contests701_800.srm712;

import java.util.ArrayList;
import java.util.List;

public class MakePalindrome {
	
	public String[] constructMinimal(String card) {
		int[] cnt = new int[26];
		for (char c : card.toCharArray()) {
			cnt[c - 'a']++;
		}
		List<String> result = new ArrayList<>();
		StringBuilder word = new StringBuilder();
		int maxOdd = -1, idx = -1;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] % 2 == 0 && cnt[i] != 0) {
				for (int j = 0; j < cnt[i]; j++) {
					word.append((char) ('a' + i));
				}
				cnt[i] = 0;
			} else if (cnt[i] % 2 == 1) {
				if (cnt[i] > maxOdd) {
					maxOdd = Math.max(cnt[i], maxOdd);
					idx = i;
				}
			}
		}
		if (maxOdd != 0) {
			for (int i = 0; i < maxOdd; i++) {
				word.append((char) ('a' + idx));
			}
			cnt[idx] = 0;
		}
		result.add(make(word.toString()));
		for (int i = 0; i < 26; i++) {
			if (cnt[i] != 0) {
				StringBuilder next = new StringBuilder();
				for (int j = 0; j < cnt[i]; j++) {
					next.append((char) ('a' + i));
				}
				result.add(next.toString());
			}
		}
		return result.toArray(new String[result.size()]);
	}
	
	private String make(String word) {
		int n = word.length();
		char[] result = new char[n];
		int[] cnt = new int[26];
		for (int i = 0; i < n; i++) {
			cnt[word.charAt(i) - 'a']++;
		}
		int idx = 0;
		for (int i = 0; i < 26; i++) {
			int count = cnt[i];
			if (count % 2 == 0) {
				int half = count / 2;
				for (int j = idx; j < idx + half; j++) {
					result[j] = result[n - j - 1] = (char) ('a' + i);
				}
				idx += half;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (cnt[i] % 2 == 1) {
				for (int j = idx; j < idx + cnt[i]; j++) {
					result[j] = (char) ('a' + i);
				}
				break;
			}
		}
		return new String(result);
	}
	
}
