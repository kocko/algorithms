package uva.volume106;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionAgain implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextInt()) {
            int n = in.nextInt(), m = in.nextInt(), sum = 0;
            int[] x = new int[n + m];
            for (int i = 0; i < n + m; i++) {
                x[i] = in.nextInt();
                sum += x[i];
            }
            int offset = 2600;
            boolean[][] dp = new boolean[51][5200];
            dp[0][offset] = true;
            for (int i = 0; i < n + m; i++) {
                List<int[]> list = new ArrayList<>();
                for (int j = 0; j <= i && j < m; j++) {
                    for (int k = 0; k < 5200; k++) {
                        if (dp[j][k]) {
                            list.add(new int[]{j + 1, k + x[i]});
                        }
                    }
                }
                for (int[] pair : list) {
                    dp[pair[0]][pair[1]] = true;
                }
            }
            int min = 1000000, max = -1000000;
            for (int i = 0; i < 5200; i++) {
                if (dp[m][i]) {
                    min = Math.min(min, (i - offset) * (sum - i + offset));
                    max = Math.max(max, (i - offset) * (sum - i + offset));
                }
            }
            out.println(max + " " + min);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (ExpressionAgain instance = new ExpressionAgain()) {
            instance.solve();
        }
    }
}
