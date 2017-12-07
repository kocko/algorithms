package uva.volume110;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.sort;

public class ExactSum implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int INF = 10000002;
        do {
            int n = parseInt(in.nextLine());
            int[] books = new int[n];
            String[] split = in.nextLine().split("\\s+");
            for (int i = 0; i < n; i++) {
                books[i] = parseInt(split[i]);
            }
            int money = parseInt(in.nextLine());
            int a = 0, b = INF;
            sort(books);
            for (int i = 0; i < n; i++) {
                int x = books[i], target = money - books[i];
                if (target >= x) {
                    int max = -1;
                    int left = i + 1, right = n - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (books[mid] > target) {
                            right = mid - 1;
                        } else if (books[mid] < target) {
                            left = mid + 1;
                        } else {
                            max = Math.max(max, mid);
                            left = mid + 1;
                        }
                    }
                    if (max != -1 && max - i < b - a) {
                        a = i;
                        b = max;
                    }
                }
            }
            out.printf("Peter should buy books whose prices are %d and %d.\n", books[a], books[b]);
            out.println();
            if (in.hasNextLine()) {
                in.nextLine();
            }
        } while (in.hasNextLine());
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ExactSum instance = new ExactSum()) {
            instance.solve();
        }
    }
}
