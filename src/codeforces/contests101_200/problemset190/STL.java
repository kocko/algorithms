package codeforces.contests101_200.problemset190;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STL implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        word = in.next();
        recurse();
        if (error || in.hasNext()) {
            out.println("Error occurred");
        } else {
            out.println(result);
        }
    }

    private StringBuilder result = new StringBuilder();
    private String word;

    private boolean error;

    private void recurse() {
        if (in.hasNext()) {
            word = in.next();
            result.append(word);
            if ("pair".equals(word)) {
                result.append("<");
                recurse();
                result.append(",");
                recurse();
                result.append(">");
            }
        } else {
            error = true;
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (STL instance = new STL()) {
            instance.solve();
        }
    }
}
