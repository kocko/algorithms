package codeforces.contests001_100.problemset004;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MysteriousPresent {

	static class Envelope {
		int id;
		int width;
		int height;

		Envelope(int id, int width, int height) {
			this.id = id;
			this.width = width;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		TreeSet<Envelope> chain = new TreeSet<Envelope>(new Comparator<Envelope>() {
			@Override
			public int compare(Envelope o1, Envelope o2) {
				int widthComparison = Integer.compare(o1.width, o2.width);
				if (widthComparison == 0) {
					return Integer.compare(o1.height, o2.height);
				}
				return widthComparison;
			}
		});
		for (int i = 1; i <= n; i++) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			Envelope e = new Envelope(i, width, height);
			chain.add(e);
		}
		int result = 0;
		List<Integer> resultingChain = new ArrayList<>();
		int maxHeight = 0, maxWidth = 0;
		for (Envelope e : chain) {
			if ((e.width > w && e.width > maxWidth) && 
				(e.height > h && e.height > maxHeight)) {
				result++;
				resultingChain.add(e.id);
				maxHeight = e.height;
				maxWidth = e.width;
			}
		}
		System.out.println(result);
		String spaceSeparatedNumbers = resultingChain.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
		System.out.println(spaceSeparatedNumbers);
		sc.close();
	}
	
}
