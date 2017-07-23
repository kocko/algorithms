package uva.volume001;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UnidirectionalTSP implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            m = in.nextInt();
            n = in.nextInt();
            data = new int[m][n];
            dp = new Integer[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    data[i][j] = in.nextInt();
                }
            }
            int ans = Integer.MAX_VALUE, row = -1;
            for (int i = 0; i < m; i++) {
                int value = recurse(0, i);
                if (value < ans) {
                    ans = value;
                    row = i;
                }
            }
            restorePath(row, 0);
            out.println();
            out.println(ans);
        }
    }
    
    private int n, m;
    private int[][] data;
    private Integer[][] dp;
    
    private int recurse(int col, int row) {
        if (col == n) return 0;
        if (dp[row][col] != null) return dp[row][col];
        
        int step_up = (row - 1 + m) % m;
        int up = recurse(col + 1, step_up);
        
        int right = recurse(col + 1, row);
        
        int step_down = (row + 1) % m;
        int down = recurse(col + 1, step_down);
        
        return dp[row][col] = data[row][col] + min(up, right, down);
    }
    
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
    private void restorePath(int row, int col) {
        if (col > 0) out.print(' ');
        
        out.print(row + 1);
        
        Set<Integer> set = new TreeSet<>();
        int target = dp[row][col] - data[row][col];
        
        if (col < n - 1) {
            int up = (row - 1 + m) % m, down = (row + 1) % m;
            if (dp[up][col + 1] == target) set.add(up);
            if (dp[row][col + 1] == target) set.add(row);
            if (dp[down][col + 1] == target) set.add(down);

            restorePath(set.iterator().next(), col + 1);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (UnidirectionalTSP instance = new UnidirectionalTSP()) {
            instance.solve();
        }
    }

}
