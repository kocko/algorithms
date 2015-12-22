package hackerrank.contests.indeedprime;

import java.util.Scanner;

public class RelatedSpecies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }
            findC(a, b);
        }
        sc.close();
    }

    static void findC(int[] a, int[] b) {
        int n = a.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(a[i], b[i]);
            int max = Math.max(a[i], b[i]);
            if (i == 0) result[i] = min;
            else {
                if (min < result[i - 1]) {
                    if (max < result[i - 1]) {
                        System.out.println("NO");
                        return;
                    } else {
                        result[i] = max;
                    }
                } else {
                    result[i] = min;
                }
            }
        }
        System.out.println("YES");
    }

}
