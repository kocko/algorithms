package uva.volume113;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Newspaper implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            int n = in.nextInt();
            Map<Character, Long> menu = new HashMap<>();
            for (int i = 0; i < n; i++) {
                menu.put(in.next().charAt(0), in.nextLong());
                in.nextLine();
            }
            int lines = in.nextInt();
            in.nextLine();
            long result = 0;
            while (lines-- > 0) {
                String line = in.nextLine();
                for (char c : line.toCharArray()) {
                    result += menu.getOrDefault(c, 0L);
                }
            }
            out.printf("%.2f$\n", result / 100.);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Newspaper instance = new Newspaper()) {
            instance.solve();
        }
    }
}
