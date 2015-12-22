package hackerrank.contests.indeedprime;

import java.util.Scanner;

public class TheUltimateQuestion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a + b + c == 42) {
            System.out.println(a + "+" + b + "+" + c);
        } else if (a * b + c == 42) {
            System.out.println(a + "*" + b + "+" + c);
        } else if (a + b * c == 42) {
            System.out.println(a + "+" + b + "*" + c);
        } else if (a * b * c == 42) {
            System.out.println(a + "*" + b + "*" + c);
        } else {
            System.out.println("This is not the ultimate question");
        }
    }

}
