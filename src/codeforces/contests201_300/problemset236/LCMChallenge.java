package codeforces.contests201_300.problemset236;

import java.util.Scanner;

public class LCMChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findLCM(n));
        sc.close();
    }

    static long findLCM(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 6;
        else {
            if (n % 2 == 1) return ((long) n * (n - 1) * (n - 2));
            else {
                if (n % 3 == 0) return ((long) (n - 1) * (n - 2) * (n - 3));
                else return ((long) n * (n - 1) * (n - 3));
            }
        }
    }

}
