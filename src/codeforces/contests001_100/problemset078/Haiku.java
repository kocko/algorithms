package codeforces.contests001_100.problemset078;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Haiku implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean ok = true;
        for (int i = 1; i <= 3; i++) {
            String line = in.nextLine().trim();
            if (i % 2 == 0) {
                ok &= ok(line, 7);
            } else {
                ok &= ok(line, 5);
            }
        }
        out.println(ok ? "YES" : "NO");
    }
    
    private boolean ok(String line, int k) {
        int vowels = 0;
        for (char c : line.toCharArray()) {
            if (isVowel(c)) {
                vowels++;
            }
        }
        return vowels == k;
    }
    
    private boolean isVowel(char c) {
        return "aeoui".indexOf(c) >= 0;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Haiku instance = new Haiku()) {
            instance.solve();
        }
    }
}
