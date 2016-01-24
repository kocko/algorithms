package codeforces.contests600_699.problemset617;

import java.util.Scanner;

public class Polyline {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(), y1 = sc.nextInt(),
            x2 = sc.nextInt(), y2 = sc.nextInt(),
            x3 = sc.nextInt(), y3 = sc.nextInt();
        int a = parallel(x1, x2) + parallel(x2, x3) + parallel(x1, x3) +
                parallel(y1, y2) + parallel(y2, y3) + parallel(y1, y3);
        int result = 3;
        if (a == 3) result = 1;
        else if (a == 2) result = 2;
        System.out.println(result);
        sc.close();
    }

    static int parallel(int m, int n) {
        return (m == n) ? 1 : 0;
    }

}
