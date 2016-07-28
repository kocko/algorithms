package codeforces.contests001_100.problemset060;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WhereAreMyFlakes implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] firstLine = in.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]), m = Integer.parseInt(firstLine[1]);
        int left = 0, right = n + 1;
        while (m-- > 0) {
            String next = in.nextLine();
            String[] split = next.split("\\s+");
            int update = Integer.parseInt(split[split.length - 1]);
            if (next.startsWith("To the left of ")) {
                if (update < right) {
                    right = update;
                }
            } else {
                if (update > left) {
                    left = update;
                }
            }
            if (left + 1 >= right) {
                out.println(-1);
                return;
            }
        }
        out.println(right - 1 - left);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (WhereAreMyFlakes instance = new WhereAreMyFlakes()) {
            instance.solve();
        }
    }
}
