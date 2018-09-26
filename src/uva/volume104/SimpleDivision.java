package uva.volume104;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SimpleDivision implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (true) {
            List<Integer> list = new ArrayList<>();
            int next;
            while ((next = in.nextInt()) != 0) {
                list.add(next);
            }
            if (list.size() == 0) break;
            list.sort(Comparator.naturalOrder());
            int result = 0;
            for (int i = 1; i < list.size(); i++) {
                result = gcd(result, list.get(i) - list.get(i - 1));
            }
            out.println(result);
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (SimpleDivision instance = new SimpleDivision()) {
            instance.solve();
        }
    }
}
