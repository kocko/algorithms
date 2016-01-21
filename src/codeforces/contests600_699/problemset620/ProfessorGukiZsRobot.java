package codeforces.contests600_699.problemset620;

import java.util.Scanner;

public class ProfessorGukiZsRobot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println(Math.max(Math.abs(y1 - y2), Math.abs(x1 - x2)));
        sc.close();
    }
}
