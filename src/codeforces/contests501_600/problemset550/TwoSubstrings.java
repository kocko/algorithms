package codeforces.contests501_600.problemset550;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class TwoSubstrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        sc.close();
        Integer[] ab = findIndices(word, 'A', 'B');
        Integer[] ba = findIndices(word, 'B', 'A');
        for (Integer i : ab) {
            for (Integer j : ba) {
                if (abs(i - j) >= 2) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    static Integer[] findIndices(char[] word, char x, char y) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < word.length - 1; i++) {
            if (word[i] == x && word[i + 1] == y) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

}
