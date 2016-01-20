package codeforces.contests301_400.problemset349;

import java.util.Scanner;

public class CinemaLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b25 = 0, b50 = 0;
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            if (next == 25) b25++;
            else if (next == 50) {
                if (b25 > 0) {
                    b25--;
                    b50++;
                }
                else {
                    System.out.println("NO");
                    return;
                }
            } else if (next == 100) {
                if (b25 > 0 && b50 > 0) {
                    b25--; b50--;
                } else if (b25 >= 3) {
                    b25 -= 3;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        sc.close();
    }
}
