package codeforces.contests600_699.problemset600;

import java.util.Arrays;
import java.util.Scanner;

public class QueriesAboutLessOrEqualElements {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            int count = findCount(a, b);
            System.out.print(count + " ");
        }
        sc.close();
        System.out.println();
    }
    
    static int findCount(int[] a, int b) {
        int index = a.length / 2;
        return binary(a, b, index);
    }
    
    static int binary(int[] a, int b, int index) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > b) {
                if (mid == 0) return 0;
                if (a[mid - 1] <= b) return mid;
                else hi = mid - 1;
            } else {
                if (mid == a.length - 1) return mid + 1;
                if (a[mid + 1] <= b) lo = mid + 1;
                else return mid + 1;
            }
        }
        return 0;
    }
    
}
