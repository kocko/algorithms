package uva.volume110;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AndysSecondDictionary implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        Set<String> set = new TreeSet<>();
        StringBuilder builder = new StringBuilder();
        while (in.hasNextLine()) {
            String line = in.nextLine().toLowerCase();
            int n = line.length();
            if (n == 0) continue;
            boolean preserve = line.charAt(n - 1) == '-';
            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    builder.append(c);
                } else {
                    if (c == '-' && i < n - 1) {
                        builder.append(c);
                    } else {
                        if (i < n - 1) {
                            set.add(builder.toString());
                            builder = new StringBuilder();
                        }
                    }
                }
            }
            if (!preserve) {
                set.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        set.stream().filter(x -> x.length() >= 1).forEach(out::println);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (AndysSecondDictionary instance = new AndysSecondDictionary()) {
            instance.solve();
        }
    }
}
