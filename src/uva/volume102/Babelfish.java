package uva.volume102;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Babelfish implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean queryMode = false;
        Map<String, String> map = new HashMap<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() == 0) {
                queryMode = true;
            } else {
                if (!queryMode) {
                    String[] split = line.split("\\s+");
                    map.put(split[1], split[0]);
                } else {
                    out.println(map.getOrDefault(line, "eh"));
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Babelfish instance = new Babelfish()) {
            instance.solve();
        }
    }
}
