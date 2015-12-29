package codeforces.contests201_300.problemset282;

import java.util.Scanner;

public class BitPlusPlus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            switch (next) {
                case "X++":
                case "++X": {
                    result++;
                    break;
                }
                case "X--":
                case "--X": {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}
