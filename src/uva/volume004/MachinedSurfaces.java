package uva.volume004;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

public class MachinedSurfaces implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = parseInt(in.nextLine())) != 0) {
            int[] gap = new int[n];
            int minShift = 50;
            for (int i = 0; i < n; i++) {
                char[] x = in.nextLine().toCharArray();
                int current = 0;
                for (int j = 0; j < 25; j++) {
                    if (x[j] != 'X') {
                        current++;
                    }
                }
                minShift = min(minShift, current);
                gap[i] = current;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += (gap[i] - minShift);
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
        try (MachinedSurfaces instance = new MachinedSurfaces()) {
            instance.solve();
        }
    }
}
