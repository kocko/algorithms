package codeforces.contests001_100.problemset035;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShellGame {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int now = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == now) {
                now = b;
            } else if (b == now) {
                now = a;
            }
        }
        sc.close();
        PrintWriter out = new PrintWriter("output.txt");
        out.println(now);
        out.close();
    }

}
