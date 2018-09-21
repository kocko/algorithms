package uva.volume100;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JollyJumpers implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                int abs = Math.abs(x[i] - x[i - 1]);
                map.put(abs, map.getOrDefault(abs, 0) + 1);
            }
            boolean ok = true;
            for (int i = 1; i < n; i++) {
                ok &= map.getOrDefault(i, 0) == 1;
            }
            out.println(ok ? "Jolly" : "Not jolly");
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }


    public static void main(String[] args) throws IOException {
        try (JollyJumpers instance = new JollyJumpers()) {
            instance.solve();
        }
    }
}
