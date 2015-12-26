package codeforces.contests101_200.problemset137;

import java.util.Scanner;

public class PostcardsAndPhotos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] wall = sc.next().toCharArray();
        int current = 1;
        int last = wall[0];
        int result = 1;
        for (int i = 1; i < wall.length; i++) {
            if (current == 5) {
                result++;
                current = 1;
            } else {
                if (wall[i] == last) {
                    current++;
                } else {
                    result++;
                    current = 1;
                }
            }
            last = wall[i];
        }
        System.out.println(result);
        sc.close();
    }

}
