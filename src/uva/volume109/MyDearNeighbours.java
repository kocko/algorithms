package uva.volume109;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyDearNeighbours implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = parseInt(in.nextLine());
        while (t-- > 0) {
            int p = parseInt(in.nextLine());
            int[] out = new int[p + 1];
            int min = 100000000;
            for (int i = 1; i <= p; i++) {
                String line = in.nextLine();
                Scanner sc = new Scanner(line);
                int count = 0;
                while (sc.hasNextInt()) {
                    sc.nextInt();
                    count++;
                }
                out[i] = count;
                if (out[i] < min) min = out[i];
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= p; i++) {
                if (out[i] == min) {
                    result.add(i);
                }
            }
            int k = result.size();
            for (int i = 0; i < k; i++) {
                this.out.print(result.get(i));
                if (i < k - 1) this.out.print(' ');
            }
            this.out.println();
            if (t > 0) {
                in.nextLine();
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (MyDearNeighbours instance = new MyDearNeighbours()) {
            instance.solve();
        }
    }
}
