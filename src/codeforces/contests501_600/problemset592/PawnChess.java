package codeforces.contests501_600.problemset592;

import java.util.Scanner;

/**
 * Code forces - Problem 592 A
 */
public class PawnChess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = 7, b = 7;
        String[] board = new String[8];
        for (int i = 0; i < 8; i++) {
            board[i] = sc.nextLine();
        }
        int[] score = new int[8];
        out: for (int i = 0; i < 8; i++) {
            String line = board[i];
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == 'B') {
                    score[j] = -1;
                } else if (line.charAt(j) == 'W') {
                    if (score[j] != -1) {
                        w = i;
                        break out;
                    }
                }
            }
        }
        score = new int[8];
        out: for (int i = 7; i >= 0; i--) {
            String line = board[i];
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == 'W') {
                    score[j] = -1;
                } else if (line.charAt(j) == 'B') {
                    if (score[j] != -1) {
                        b = 7 - i;
                        break out;
                    }
                }
            }
        }
        System.out.println(w <= b ? "A" : "B");
        sc.close();
    }
        
}