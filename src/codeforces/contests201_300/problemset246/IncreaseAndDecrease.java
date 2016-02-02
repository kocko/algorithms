package codeforces.contests201_300.problemset246;

import java.util.Scanner;

public class IncreaseAndDecrease {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        for (int i = 0 ; i < n; i++) {
            total += sc.nextInt();
        }
        System.out.println((total % n == 0) ? n : (n - 1));
        sc.close();
    }

}
