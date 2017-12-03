package uri.volume012;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InsideOut implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = Integer.parseInt(in.nextLine());
        while (q-- > 0) {
            String line = in.nextLine();
            int n = line.length(), half = n / 2;
            for (int i = half - 1; i >= 0; i--) {
                out.print(line.charAt(i));
            }
            for (int i = n - 1; i >= half; i--) {
                out.print(line.charAt(i));
            }
            out.println();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (InsideOut instance = new InsideOut()) {
            instance.solve();
        }
    }
}
