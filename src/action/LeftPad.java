package action;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class LeftPad implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        StringBuilder sb = new StringBuilder();
        String s = in.next();
        int n = parseInt(in.next());
        char delimiter = ' ';
        if (in.hasNext()) {
            delimiter = in.next().charAt(0);
        }
        for (int i = 0; i < n; i++) {
            sb.append(delimiter);
        }
        out.println(sb.append(s));
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }


    public static void main(String[] args) throws IOException {
        try (LeftPad instance = new LeftPad()) {
            instance.solve();
        }
    }
}
