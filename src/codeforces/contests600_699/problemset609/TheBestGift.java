package codeforces.contests600_699.problemset609;

import java.util.Scanner;

public class TheBestGift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[200001];
        for (int i = 0; i < n; i++) {
            x[sc.nextInt()]++;
        }
        long result = 0;
        for (int i = 0; i < 200001; i++) {
            if (x[i] > 0) {
                result += x[i] * (n - x[i]);
            }
        }
        System.out.println(result / 2);
        sc.close();
    }

}
