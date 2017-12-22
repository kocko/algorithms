package uva.volume102;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;

public class HardwoodSpecies implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = parseInt(in.nextLine());
        in.nextLine();
        while (t-- > 0) {
            String line;
            Map<String, Integer> map = new TreeMap<>();
            double total = 0;
            while (in.hasNextLine() && (line = in.nextLine()).length() > 0) {
                total++;
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                double fraction = (100. * entry.getValue()) / total;
                out.printf("%s %.4f\n", entry.getKey(), fraction);
            }
            if (t > 0) out.println();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (HardwoodSpecies instance = new HardwoodSpecies()) {
            instance.solve();
        }
    }
}
