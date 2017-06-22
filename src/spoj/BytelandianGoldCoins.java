package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BytelandianGoldCoins implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private Map<Integer, Long> dp = new HashMap<>();
    
    private long recurse(int n) {
        if (dp.containsKey(n)) return dp.get(n);
        
        if (n < 12) return n;
        
        long count = recurse(n / 4) + recurse(n / 3) + recurse(n / 2);
        
        dp.put(n, count);
        return count;
    }

    public void solve() {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            out.println(recurse(n));
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (BytelandianGoldCoins instance = new BytelandianGoldCoins()) {
            instance.solve();
        }
    }
}
