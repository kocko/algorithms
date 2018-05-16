package uva.volume100;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TightWords implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            k = in.nextInt();
            int n = in.nextInt();
            test = new double[n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k + 1; j++) {
                    test[i][j] = -1d;
                }
            }
            double percentage = 0;
            for (int i = 0; i <= k; i++) {
                percentage += test(n - 1, i);
            }
            out.println(String.format("%.5f", percentage));
        }
    }

    private int k;
    private double[][] test;

    private double test(int idx, int last) {
        if (idx == 0) return 100.0 / (k + 1.);

        if (test[idx][last] != -1.0) return test[idx][last];

        double result = 0d;
        for (int i = last - 1; i <= last + 1; i++) {
            if (i >= 0 && i <= k) {
                result += test(idx - 1, i) / (k + 1.);
            }
        }
        return test[idx][last] = result;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TightWords instance = new TightWords()) {
            instance.solve();
        }
    }
}
