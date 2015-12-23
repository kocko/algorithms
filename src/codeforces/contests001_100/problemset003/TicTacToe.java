package codeforces.contests001_100.problemset003;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] board = new String[3];
        int crosses = 0, noughts = 0;
        for (int i = 0; i < 3; i++) {
            String next = sc.next();
            board[i] = next;
            for (int j = 0; j < 3; j++) {
                if (next.charAt(j) == 'X') crosses++;
                else if (next.charAt(j) == '0') noughts++;
            }
        }
        sc.close();
        int x3 = 0, o3 = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                x3 += (board[i].charAt(0) == 'X') ? 1 : 0;
                o3 += (board[i].charAt(0) == '0') ? 1 : 0;
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                x3 += (board[0].charAt(i) == 'X') ? 1 : 0;
                o3 += (board[0].charAt(i) == '0') ? 1 : 0;
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            x3 += (board[1].charAt(1) == 'X') ? 1 : 0;
            o3 += (board[1].charAt(1) == '0') ? 1 : 0;
        }
        if (board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2)) {
            x3 += (board[1].charAt(1) == 'X') ? 1 : 0;
            o3 += (board[1].charAt(1) == '0') ? 1 : 0;
        }

        if ((crosses - noughts < 0 || crosses - noughts > 1) || (x3 > 0 && o3 > 0) || (x3 > 0 & (crosses - noughts != 1) || (o3 > 0 && crosses != noughts))) {
            System.out.println("illegal");
        } else if (x3 > 0) {
            System.out.println("the first player won");
        } else if (o3 > 0) {
            System.out.println("the second player won");
        } else if (crosses == noughts) {
            System.out.println("first");
        } else if (crosses + noughts < 9 && crosses - noughts == 1) {
            System.out.println("second");
        } else {
            System.out.println("draw");
        }
    }

}
