package codeforces.contests601_700.problemset617;

import java.util.Scanner;

public class Polyline {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), y1 = sc.nextInt(),
                x2 = sc.nextInt(), y2 = sc.nextInt(),
                x3 = sc.nextInt(), y3 = sc.nextInt();
        sc.close();
        int result = 1;
        if ((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) result = 1;
        else
            if ((x1 == x2 && !between(y3, y1, y2)) ||
                (x2 == x3 && !between(y1, y3, y2)) ||
                (x1 == x3 && !between(y2, y1, y3)) ||
                (y1 == y2 && !between(x3, x1, x2)) ||
                (y2 == y3 && !between(x1, x2, x3)) ||
                (y3 == y1 && !between(x2, x1, x3))) result = 2;
        else result = 3;
        System.out.println(result);
    }

    static boolean between(int a, int b, int c) {
        int min = Math.min(b, c), max = Math.max(b, c);
        return a > min && a < max;
    }

}
