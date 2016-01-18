package codeforces.contests001_100.problemset054;

import java.util.Scanner;

public class ChatRoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        char[] hello = {'h', 'e', 'l', 'l', 'o'};
        int next = 0;
        for (char c : word) {
            if (next == 5) {
                System.out.println("YES");
                return;
            }
            if (c == hello[next]) {
                next++;
            }
        }

        System.out.println(next >= 5 ? "YES" : "NO");
        sc.close();
    }
}
