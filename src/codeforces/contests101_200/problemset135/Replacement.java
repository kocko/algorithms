package codeforces.contests101_200.problemset135;

import java.util.Arrays;
import java.util.Scanner;

public class Replacement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int index = 0, largest = -1;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            if (x[i] > largest) {
                largest = x[i];
                index = i;
            }
        }
        if (largest == 1) {
            x[index] = 2;
        } else {
            x[index] = 1;
        }
        Arrays.sort(x);
        for (int i : x) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
