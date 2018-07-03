package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.min;

public class EditDistanceAgain implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            char[] x = in.next().toCharArray();
            int a = 0, b = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] >= 'A' && x[i] <= 'Z' && i % 2 == 1) a++;
                if (x[i] >= 'a' && x[i] <= 'z' && i % 2 == 0) a++;
            }
            for (int i = 0; i < x.length; i++) {
                if (x[i] >= 'A' && x[i] <= 'Z' && i % 2 == 0) b++;
                if (x[i] >= 'a' && x[i] <= 'z' && i % 2 == 1) b++;
            }
            out.println(min(a, b));
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (EditDistanceAgain instance = new EditDistanceAgain()) {
            instance.solve();
        }
    }
}
