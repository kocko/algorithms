package uva.volume104;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HomerSimpson implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split("\\s+");
            int m = Integer.parseInt(split[0]), n = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);

            int[] dp = new int[t + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= t; i++) {
                int x = (i - m >= 0) ? dp[i - m] : -1;
                if (x >= 0) x++;
                
                int y = (i - n >= 0) ? dp[i - n] : -1;
                if (y >= 0) y++;
                
                dp[i] = Math.max(x, y);
            }
            if (dp[t] != -1) {
                out.print(dp[t]);
            } else {
                int i = t;
                while (dp[i] == -1) i--;
                out.print(dp[i]);
                out.print(' ');
                out.print(t - i);
            }
            out.println();
        }
    }
    
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (HomerSimpson instance = new HomerSimpson()) {
            instance.solve();
        }
    }
}
