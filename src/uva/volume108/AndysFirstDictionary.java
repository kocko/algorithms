package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AndysFirstDictionary implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        Set<String> set = new TreeSet<>();
        while (in.hasNextLine()) {
            String next = in.nextLine().toLowerCase();
            StringBuilder builder = new StringBuilder();
            for (char c : next.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    builder.append(c);
                } else {
                    set.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            set.add(builder.toString());
        }
        set.stream().filter(x -> x.length() >= 1).forEach(out::println);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (AndysFirstDictionary instance = new AndysFirstDictionary()) {
            instance.solve();
        }
    }
}
