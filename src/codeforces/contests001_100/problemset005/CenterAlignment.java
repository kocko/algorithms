package codeforces.contests001_100.problemset005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CenterAlignment {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        int max = 0;
        for (String s = reader.readLine(); s != null; s = reader.readLine()) {
            if ("kocko".equals(s)) break;
            lines.add(s);
            max = Math.max(max, s.length());
        }

        max += 2;

        String foo = topBottom(max);
        writer.println(foo);
        for (String line : lines) {
            print(line, max);
        }
        writer.println(foo);
        writer.flush();
    }

    static int left = 0, right = 1;

    static String topBottom(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += '*';
        }
        return result;
    }

    private static void printSpaces(int limit) {
        for (int i = 0; i < limit; i++) {
            writer.print(" ");
        }
    }

    static void print(String line, int max) {
        int length = line.length();
        writer.print("*");
        int diff = max - length - 2;
        if (diff % 2 == 0) {
            printSpaces(diff / 2);
            writer.print(line);
            printSpaces(diff / 2);
        } else {
            printSpaces((diff / 2) + (left % 2));
            writer.print(line);
            printSpaces((diff / 2) + (right % 2));
            left++; right++;
        }
        writer.print("*\n");
    }

}
