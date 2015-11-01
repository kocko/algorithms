package hackerrank.projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DistinctPowers {
	
	static class NumberSplit {
		private TreeMap<Integer, Integer> split;
		
		public NumberSplit(int n, int pow) {
			split = new TreeMap<>();
			splitIntoPrimePowers(n, pow);
		}
		
		private void splitIntoPrimePowers(int n, int pow) {
			while (n > 1) {
				inner: for (int i = 2; i <= n; i++) {
					if (n % i == 0) {
						addDivisor(i);
						n /= i;
						break inner;
					}
				}
			}
			for (Map.Entry<Integer, Integer> entry : split.entrySet()) {
				split.put(entry.getKey(), entry.getValue() * pow);
			}
		}
		
		private void addDivisor(int i) {
			if (split.containsKey(i)) {
				split.put(i, split.get(i) + 1);
			} else {
				split.put(i, 1);
			}
		}
		
	}

	
	public static void main(String[] args) {
		List<NumberSplit> set = new ArrayList<>();
		for (int i = 2; i <= 100; i++) {
			for (int p = 2; p <= 100; p++) {
				NumberSplit next = new NumberSplit(i, p);
				if (!setContainsNext(set, next)) {
					set.add(next);
				}
				
			}
		}
		System.out.println(set.size());
	}
	
	static boolean setContainsNext(List<NumberSplit> list, NumberSplit next) {
		for (NumberSplit ns : list) {
			if (same(ns, next)) {
				return true;
			}
		}
		return false;
	}
	
	static boolean same(NumberSplit a, NumberSplit b) {
		Map<Integer, Integer> mapA = a.split;
		Map<Integer, Integer> mapB = b.split;
		if (mapA.size() == mapB.size()) {
			for (Entry<Integer, Integer> entry : mapA.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();
				if (!mapB.containsKey(key) || !mapB.get(key).equals(value)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
}
