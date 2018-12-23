package uva.volume006;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TheFallingLeaves implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 0;
        while (in.hasNextInt()) {
            piles = new TreeMap<>();
            recurse(0);
            if (piles.size() == 0) break;
            if (testCase > 0) out.println();
            out.printf("Case %d:\n", ++testCase);
            int cnt = 1;
            for (Map.Entry<Integer, Integer> entry : piles.entrySet()) {
                out.print(entry.getValue());
                if (cnt++ <= piles.size() - 1) out.print(' ');
            }
            out.print("\n");
        }
        out.println();
    }
    
    private Map<Integer, Integer> piles;
    
    private void recurse(int offset) {
        int value = in.nextInt();
        if (value == -1) return;
        piles.put(offset, piles.getOrDefault(offset, 0) + value);
        recurse(offset - 1);
        recurse(offset + 1);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TheFallingLeaves instance = new TheFallingLeaves()) {
            instance.solve();
        }
    }
}
