package codeforces.contests701_800.problemset722;

import java.io.IOException;
import java.util.Scanner;

public class VersePattern {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] p = new int[n];
        String[] next = sc.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(next[i]);
        }
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (!ok(line, p[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        sc.close();
    }
    
    private static boolean ok(String line, int p) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                count++;
            }
            
        }
        return count == p;
    }
}
