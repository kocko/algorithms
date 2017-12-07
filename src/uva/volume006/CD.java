package uva.volume006;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CD implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            int max = in.nextInt();
            int n = in.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            int result = 0, mask = 0; 
            for (int i = 1; i <= (1 << n) - 1; i++) {
                int current = 0;
                for (int j = 0; j <= 20; j++) {
                    if ((i & (1 << j)) != 0) {
                        current += x[j];
                    }
                }
                if (current > result && current <= max) {
                    result = current;
                    mask = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    out.print(x[i]);
                    out.print(' ');
                }
            }
            out.printf("sum:%d\n", result);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (CD instance = new CD()) {
            instance.solve();
        }
    }
}
