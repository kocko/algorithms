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
            char[][] x = new char[n][25];
            int[] gap = new int[n];
            int minShift = 1000;
            for (int i = 0; i < n; i++) {
                x[i] = in.nextLine().toCharArray();
                int current = 0, start = -1, end = -1;
                for (int j = 0; j < 25; j++) {
                    if (x[i][j] != 'X') {
                        current++;
                        if (start == -1) start = end = j;
                        else end = j;
                    }
                }
                if (end == -1) {
                    minShift = 0;
                } else {
                    minShift = min(minShift, end - start + 1);
                }
                gap[i] = current;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (gap[i] > 0) {
                    result += (gap[i] - minShift);
                }
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
