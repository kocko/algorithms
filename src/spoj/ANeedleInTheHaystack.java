package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.max;

public class ANeedleInTheHaystack implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean found = false;
        while (in.hasNextInt()) {
            if (found) {
                out.println();
            }
            found = false;
            int m = in.nextInt();
            char[] pattern = in.next().toCharArray(), text = in.next().toCharArray();
            int n = text.length;
            int[] fail = new int[m];
            fail[0] = 0;
            for (int i = 1; i < m; i++) {
                fail[i] = fail[i - 1];
                while (fail[i] > 0 && pattern[i] != pattern[fail[i]]) {
                    fail[i] = fail[fail[i] - 1];
                }
                if (pattern[fail[i]] == pattern[i]) {
                    fail[i]++;
                }
            }
            int start = 0, match = 0;
            while (start + m <= n) {
                while (match < m && pattern[match] == text[start + match]) {
                    match++;
                }
                if (match == m) {
                    found = true;
                    out.println(start);
                }
                match = max(0, match - 1);
                start += match - fail[match] + 1;
                match = fail[match];
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ANeedleInTheHaystack instance = new ANeedleInTheHaystack()) {
            instance.solve();
        }
    }
}
