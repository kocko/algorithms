package codeforces.contests101_200.problemset112;

import java.util.Scanner;

public class PetyaAndStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = sc.next().toLowerCase().compareTo(sc.next().toLowerCase());
        System.out.println(result < 0 ? -1 : (result > 0 ? 1 : 0));
        sc.close();
    }
}
