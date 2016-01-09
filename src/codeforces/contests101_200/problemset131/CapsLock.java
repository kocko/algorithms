package codeforces.contests101_200.problemset131;

import java.util.Scanner;

public class CapsLock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        if (isAllUppercase(word)) {
            System.out.println(word.toLowerCase());
        } else if (isFirstLowerOthersUpper(word)) {
            char[] converted = convert(word);
            for (char c : converted) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            System.out.println(word);
        }
        sc.close();
    }

    static boolean isAllUppercase(String word) {
        for (char c : word.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    static boolean isFirstLowerOthersUpper(String word) {
        char[] chars = word.toCharArray();
        boolean firstIsLowerCase = chars[0] >= 'a' && chars[0] <= 'z';
        boolean restAreUpperCase = true;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c < 'A' || c > 'Z') {
                restAreUpperCase = false;
            }
        }
        return firstIsLowerCase && restAreUpperCase;
    }

    static char[] convert(String word) {
        char[] chars = word.toCharArray();
        char[] result = new char[chars.length];
        int diff = chars[0] - 'a';
        result[0] = (char) ('A' + diff);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            diff = c - 'A';
            result[i] = (char) ('a' + diff);
        }
        return result;
    }
}
