package codeforces.contests600_699.problemset610;

import java.util.Scanner;

public class PashaAndStick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        } else {
            System.out.println((int) Math.ceil(n / 4.0) - 1);
        }
        sc.close();
    }

}
