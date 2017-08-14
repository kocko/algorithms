package codeforces.contests801_900.problemset837;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextVolume implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = Integer.parseInt(in.nextLine());
        char[] x = in.nextLine().toCharArray();
        int current = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] == ' ') {
                max = Math.max(current, max);
                current = 0;
            } else if (x[i] >= 'A' && x[i] <= 'Z') {
                current++;
            }
        }
        out.println(Math.max(current, max));
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TextVolume instance = new TextVolume()) {
            instance.solve();
        }
    }
}
