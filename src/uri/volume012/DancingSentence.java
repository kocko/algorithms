package uri.volume012;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingSentence implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            dance(line);
        }
    }

    private void dance(String x) {
        boolean up = true;
        for (char c : x.toCharArray()) {
            char next = c;
            if (c >= 'a' && c <= 'z') {
                if (up) {
                    next = (char) ('A' + (c - 'a'));
                    up = false;
                } else {
                    up = true;
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (!up) {
                    next = (char) ('a' + (c - 'A'));
                    up = true;
                } else {
                    up = false;
                }
            }
            out.print(next);
        }
        out.println();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (DancingSentence instance = new DancingSentence()) {
            instance.solve();
        }
    }
}
