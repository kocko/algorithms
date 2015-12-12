package codeforces.contests600_699.problemset602;

import java.util.Scanner;

public class ApproximatingAConstantRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        System.out.println(findLongestConstantRange(list));
        sc.close();
    }

    static int findLongestConstantRange(int[] list) {
        int n = list.length;
        int min = Math.min(list[0], list[1]);
        int result = 2;
        int current = 2;
        int lastChange = 0;
        for (int i = 2; i < n; i++) {
            if (list[i] == list[i - 1]) {
                current++;
            } else {
                if (list[i] == min || list[i] == min + 1) {
                    current++;
                } else {
                    min = Math.min(list[i], list[i - 1]);
                    result = Math.max(current, result);
                    current = i - lastChange + 1;
                }
                lastChange = i;
            }
        }
        return Math.max(current, result);
    }

    //10 5 4 4 4 3 3 3 2 1 1
}
