package codeforces.contests601_700.problemset609;

import java.util.Arrays;
import java.util.Scanner;

public class USBFlashDrives {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int result = 0;
        int total = 0;
        for (int i = n - 1; i >= 0; i--) {
            total += a[i];
            result++;
            if (total >= m) {
                break;
            }
        }
        System.out.println(result);
        sc.close();
    }

}
