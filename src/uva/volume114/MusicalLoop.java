package uva.volume114;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MusicalLoop implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.nextInt()) != 0) {
            int[] x = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                x[i] = in.nextInt();
            }
            x[0] = x[n];
            x[n + 1] = x[1];
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (x[i] > x[i - 1] && x[i] > x[i + 1]) result++;
                if (x[i] < x[i - 1] && x[i] < x[i + 1]) result++;
            }
            out.println(result);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (MusicalLoop instance = new MusicalLoop()) {
            instance.solve();
        }
    }
}
