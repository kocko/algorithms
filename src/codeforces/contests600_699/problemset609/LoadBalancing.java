package codeforces.contests600_699.problemset609;

import java.util.Arrays;
import java.util.Scanner;

public class LoadBalancing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
            total += m[i];
        }
        sc.close();
        int average = total / n;
        int result = 0;
        Arrays.sort(m);
        for (int i = 0; i < n; i++) {
            if (m[i] < average) {
                result += average - m[i];
            }
        }
        total -= n * average;
        for (int i = 1; i <= total; i++) {
            if (m[n - i] < average + 1) {
                result++;
            }
        }
        System.out.println(result);
    }

}
