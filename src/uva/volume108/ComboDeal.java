package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ComboDeal implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            n = in.nextInt();
            price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = in.nextInt();
            }
            dp = new int[1000000];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = -1;
            }
            int d = in.nextInt();
            deals = new HashMap<>();
            while (d-- > 0) {
                int code = 0;
                for (int i = 0; i < n; i++) {
                    code += in.nextInt() * power[i];
                }
                int value = in.nextInt();
                if (deals.containsKey(code)) {
                    deals.put(code, Math.min(value, deals.get(code)));
                } else {
                    deals.put(code, value);
                }
            }
            int q = in.nextInt();
            while (q-- > 0) {
                int code = 0;
                for (int i = 0; i < n; i++) {
                    code += in.nextInt() * power[i];
                }
                out.println(recurse(code));
            }
        }
    }

    private int n;
    private int[] power = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
    private int[] price, dp;
    private Map<Integer, Integer> deals;

    private int recurse(int idx) {
        if (idx <= 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (less(idx, power[i])) {
                ans = Math.min(ans, price[i] + recurse(idx - power[i]));
            }
        }
        for (Map.Entry<Integer, Integer> deal : deals.entrySet()) {
            int code = deal.getKey();
            if (less(idx, code)) {
                int next = idx;
                int p = 0;
                while (code > 0) {
                    int digit = code % 10;
                    next -= digit * power[p++];
                    code /= 10;
                }
                ans = Math.min(ans, deal.getValue() + recurse(next));
            }
        }
        return dp[idx] = ans;
    }
    
    private boolean less(int x, int y) {
        boolean result = true;
        while (x > 0 && y > 0) {
            result &= x % 10 >= y % 10;
            x /= 10;
            y /= 10;
        }
        result &= y == 0;
        return result;
    }
    
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ComboDeal instance = new ComboDeal()) {
            instance.solve();
        }
    }
}
