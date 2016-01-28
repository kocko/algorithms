package hackerearth.basic.math;

import java.util.Scanner;

public class CubeChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(calculateVolume(n));
        }
        sc.close();
    }

    static long calculateVolume(long n) {
        if (n == 1) return 1;
        return 2 * (n * n + n * (n - 2) + (n - 2) * (n - 2));
    }
}
