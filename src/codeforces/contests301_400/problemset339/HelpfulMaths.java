package codeforces.contests301_400.problemset339;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("\\+");
        Arrays.sort(s);
        System.out.println(String.join("+", s));
        sc.close();
    }

}
