package codeforces.contests001_100.problemset034;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Code forces - Problem 34 C
 */
public class PageNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pages = sc.next().split(",");
		sc.close();

		Set<Integer> set = new TreeSet<Integer>();
		for (String s : pages) {
			set.add(Integer.parseInt(s));
		}

		List<String> groupedPages = standartize(set);
		String result = groupedPages.stream().collect(Collectors.joining(","));
		System.out.println(result);
	}

	static List<String> standartize(Set<Integer> set) {
		int n = set.size();
		List<String> result = new ArrayList<>();
		Integer[] pages = set.toArray(new Integer[n]);
		int groupFirst = pages[0];
		int groupPrevious = pages[0];
		for (int i = 1; i < n; i++) {
			int next = pages[i];
			if (next - groupPrevious == 1) {
				groupPrevious = next;
			} else {
				if (groupFirst == groupPrevious) {
					result.add(String.valueOf(groupFirst));
				} else {
					result.add(groupFirst + "-" + groupPrevious);
				}
				groupFirst = next;
				groupPrevious = next;
			}
		}
		if (groupFirst == groupPrevious) {
			result.add(String.valueOf(groupFirst));
		} else {
			result.add(groupFirst + "-" + groupPrevious);
		}
		return result;
	}
	
}
