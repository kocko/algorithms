package codeforces.contests501_599.problemset523;

import java.util.Scanner;

public class NameQuest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		sc.close();
		System.out.println(countWaysOfSplitting(s, t));
	}
	
	static int countWaysOfSplitting(String s, String t) {
		int m = s.length();
		int n = t.length();
		
		int a = 0;
		for (int i = 0, j = 0; j < m; i++) {
			if (i == n) {
				return 0;
			}
			if (t.charAt(i) == s.charAt(j)) {
				j++;
			}
			if (j == m) {
				a = i;
				break;
			}
		}
		
		int b = n - 1;
        for (int i = n - 1, j = m - 1; j >= 0 ; i--) {
            if (i < 0) {
                return 0;
            }
            if (t.charAt(i) == s.charAt(j)) {
                j--;
            }
            if (j < 0) {
                b = i - 1;
                break;
            }
        }
        
		if (a <= b) {
			return b - a + 1;
		}
		
		return 0;
	}
	
}
