package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.max;

public class TroubleOf13Dots implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("\\s+");
            int money = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            int[] price = new int[n];
            int[] favour = new int[n];
            for (int i = 0; i < n; i++) {
                line = in.nextLine().split("\\s+");
                price[i] = Integer.parseInt(line[0]);
                favour[i] = Integer.parseInt(line[1]);
            }
            
            int limit = money;
            if (money > 1800) limit += 200;
            
            int[] dp = new int[limit + 1];
            for (int i = 0; i < n; i++) {
                for (int j = limit; j >= price[i]; j--) {
                    if (dp[j - price[i]] > 0 || j == price[i]) {
                        dp[j] = max(dp[j], dp[j - price[i]] + favour[i]);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i <= money; i++) {
                max = max(max, dp[i]);
            }
            if (money >= 1801 && money <= 2000) {
                for (int i = 2001; i <= limit; i++) {
                    max = max(max, dp[i]);
                }
            } else {
                for (int i = 0; i <= limit; i++) {
                    max = max(max, dp[i]);
                }
            }
            out.println(max);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TroubleOf13Dots instance = new TroubleOf13Dots()) {
            instance.solve();
        }
    }
}
