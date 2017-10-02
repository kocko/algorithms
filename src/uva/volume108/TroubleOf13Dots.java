package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TroubleОf13Dots implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("\\s+");
            money = Integer.parseInt(line[0]);
            n = Integer.parseInt(line[1]);
            price = new int[n];
            favour = new int[n];
            for (int i = 0; i < n; i++) {
                line = in.nextLine().split("\\s+");
                price[i] = Integer.parseInt(line[0]);
                favour[i] = Integer.parseInt(line[1]);
            }
            dp = new int[n][money + 201];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < money + 201; j++) {
                    dp[i][j] = -1;
                }
            }
            out.println(recurse(0, money));
        }
    }
    
    private int money, n;
    private int[] price;
    private int[] favour;
    private int[][] dp;
    
    private int recurse(int idx, int total) {
        if (idx == n || total < 0) return 0;
        
        if (dp[idx][total] != -1) return dp[idx][total];
        
        int ans;
        if (total < price[idx]) {
            ans = recurse(idx + 1, total);
        } else {
            ans = Math.max(recurse(idx + 1, total), favour[idx] + recurse(idx + 1, total - price[idx]));
        }
        
        return dp[idx][total] = ans;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TroubleОf13Dots instance = new TroubleОf13Dots()) {
            instance.solve();
        }
    }
}
