package codeforces.contests401_500.problemset472;

import java.util.Scanner;

public class DesignTutorialLearnFromMath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        split(n);
        sc.close();
    }

    static void split(int n) {
        int a = 2;
        while (true) {
            if (isCompound(n - a) && isCompound(a)) break;
            a++;
        }
        System.out.print((n - a) + " " + a);
    }

    static boolean isCompound(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return true;
        }
        return false;
    }

}
