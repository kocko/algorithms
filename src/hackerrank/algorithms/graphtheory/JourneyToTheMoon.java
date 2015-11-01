package hackerrank.algorithms.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JourneyToTheMoon {

	static Map<Integer, Set<Integer>> graph;

	static boolean[] used;
	
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		graph = new HashMap<>();
		used = new boolean[n];
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			saveNode(x, y);
		}
		List<Integer> componentsCardinality = splitIntoComponents();
		long result = 0;
		for (int i = 0; i < componentsCardinality.size(); i++) {
			long x = componentsCardinality.get(i);
			result += x * (n - x);
		}
		System.out.println(result / 2);
		sc.close();
	}

	@SuppressWarnings("serial")
	static void saveNode(final int x, final int y) {
		if (graph.get(x) != null) {
			graph.get(x).add(y);
		} else {
			graph.put(x, new TreeSet<Integer>(){{ add(y); }});
		}
		if (graph.get(y) != null) {
			graph.get(y).add(x);
		} else {
			graph.put(y, new TreeSet<Integer>(){{ add(x); }});
		}
	}

	static List<Integer> splitIntoComponents() {
		List<Integer> result = new ArrayList<>();
		long total = 0;
		for (int i = 0; i < n; i++) {
			int componentSize = 0;
			if (!used[i] && graph.containsKey(i)) {
				componentSize = dfs(i);
				total += componentSize;
				result.add(componentSize);
			}
		}
		if (total < n) {
			for (int i = 0; i < n - total; i++) {
				result.add(1);
			}
		}
		return result;
	}
	
	static int dfs(int start) {
		int result = 1;
		used[start] = true;
		for (int i = 0; i < n; i++) {
			if (i != start && !used[i]) {
				if (graph.get(start) != null && graph.get(start).contains(i)) {
					used[i] = true;
					result += dfs(i);
				}
			}
		}
		return result;
	}
	
}
