package codeforces.contests501_600.problemset550;

import java.util.Scanner;

public class DivisibilityByEight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] number = sc.next().toCharArray();
        int n = number.length;
        for (int i = n - 1; i >= 0; i--) {
            int x = number[i] - '0';
            if (x % 8 == 0) {
                System.out.println("YES");
                System.out.println(x);
                return;
            }
            for (int j = i - 1; j >= 0; j--) {
                int y = 10 * (number[j] - '0');
                if ((x + y) % 8 == 0) {
                    System.out.println("YES");
                    System.out.println(x + y);
                    return;
                }
                for (int k = j - 1; k >= 0; k--) {
                    int z = 100 * (number[k] - '0');
                    if ((x + y + z) % 8 == 0) {
                        System.out.println("YES");
                        System.out.println(x + y + z);
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        sc.close();
    }
}
