package uva.volume002;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class QuirksomeSquares implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        calculate();
        while (in.hasNextInt()) {
            List<String> result = map.get(in.nextInt());
            result.forEach(out::println);
        }
    }

    private Map<Integer, List<String>> map = new HashMap<>();

    private void calculate() {
        List<String> squares = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            squares.add(valueOf(i * i));
        }
        for (String sq : squares) {
            int p = 10;
            int s = Integer.parseInt(sq);
            for (int i = 1; i <= 4; i++) {
                int a = (s / p), b = s % p;
                if (format(i, a).length() <= format(i, b).length()) {
                    if ((a + b) * (a + b) == s) {
                        List<String> list = map.getOrDefault(2 * i, new ArrayList<>());
                        list.add(format(2 * i, s));
                        map.put(2 * i, list);
                    }
                }
                p *= 10;
            }
        }
    }

    private String format(int size, int number) {
        StringBuilder result = new StringBuilder(valueOf(number));
        while (result.length() < size) result.insert(0, "0");
        return result.toString();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (QuirksomeSquares instance = new QuirksomeSquares()) {
            instance.solve();
        }
    }
}
