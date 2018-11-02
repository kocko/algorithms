package uva.volume009;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Popes implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            int l = in.nextInt(), n = in.nextInt();
            int[] count = new int[1000001];
            for (int i = 0; i < n; i++) {
                count[in.nextInt()]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            int popes = 0, start = -1;
            for (int i = 1; i <= count.length - l; i++) {
                int period = count[i + l - 1] - count[i - 1];
                if (period > popes) {
                    popes = period;
                    start = i;
                }
            }
            int left = start, right = start + l - 1, first = right;
            while (left <= right) {
                int mid = (left + right) / 2;
                int p = count[mid] - count[start - 1];
                if (p >= 1) {
                    right = mid - 1;
                    first = min(first, mid);
                } else {
                    left = mid + 1;
                }
            }
            left = start;
            right = start + l - 1;
            int last = right;
            while (left <= right) {
                int mid = (left + right) / 2;
                int p = count[mid] - count[start - 1];
                if (p < popes) {
                    left = mid + 1;
                } else if (p == popes) {
                    last = min(last, mid);
                    right = mid - 1;
                }
            }
            out.printf("%d %d %d\n", popes, first, last);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Popes instance = new Popes()) {
            instance.solve();
        }
    }
}
