package uva.volume106;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Luggage implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = Integer.parseInt(in.nextLine());
        while (t-- > 0) {
            String[] split = in.nextLine().split("\\s+");
            int n = split.length;
            weight = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(split[i]);
                total += weight[i];
            }
            if (total % 2 == 0) {
                w = total / 2;
                dp = new int[25][205];
                for (int i = 0; i < 25; i++) Arrays.fill(dp[i], -1);
                if (recurse(n - 1, w) == w) {
                    out.println("YES");
                    continue;
                } 
            }
            out.println("NO");
        }
    }
    
    private int w;
    private int[] weight;
    private int[][] dp;
    
    private int recurse(int i, int x) {
        if (i < 0 || x == 0) return 0;
        
        if (dp[i][x] != -1) return dp[i][x];
        
        if (weight[i] > x) {
            return dp[i][x] = recurse(i - 1, x);
        } else {
            return dp[i][x] = Math.max(recurse(i - 1, x), recurse(i - 1, x - weight[i]) + weight[i]);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Luggage instance = new Luggage()) {
            instance.solve();
        }
    }
}
