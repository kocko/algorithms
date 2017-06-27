package uva.volume005;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Compromise implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            a = new ArrayList<>();
            b = new ArrayList<>();
            String next;
            while (!"#".equals(next = in.next())) a.add(next);
            while (!"#".equals(next = in.next())) b.add(next);
            int n = a.size(), m = b.size();
            dp = new int[n + 1][m + 1];
            for (int[] x : dp) Arrays.fill(x, -1);
            prev = new int[n + 1][m + 1];
            recurse(n, m);
            print();
        }
    }

    private final int UPLEFT = 1, UP = 2, LEFT = 3;
    private List<String> a, b;
    private int[][] dp, prev;
    
    private int recurse(int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (a.get(i - 1).equals(b.get(j - 1))) {
            prev[i][j] = UPLEFT;
            return dp[i][j] = 1 + recurse(i - 1, j - 1);
        } else {
            int x = recurse(i - 1, j), y = recurse(i, j - 1);
            if (x > y) {
                prev[i][j] = UP;
                dp[i][j] = x;
            } else {
                prev[i][j] = LEFT;
                dp[i][j] = y;
            }
            return dp[i][j];
        }
    }
    
    private void print() {
        int i = a.size(), j = b.size();
        List<String> result = new ArrayList<>();
        while (i > 0 && j > 0) {
            switch (prev[i][j]) {
                case UPLEFT: {
                    result.add(a.get(i - 1));
                    i--;
                    j--;
                    break;
                }
                case UP: {
                    i--; 
                    break;
                }
                case LEFT: {
                    j--;
                }
            }
        }
        for (int s = result.size() - 1; s >= 1; s--) {
            out.print(result.get(s));
            out.print(' ');
        }
        out.println(result.get(0));
    }
    
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Compromise instance = new Compromise()) {
            instance.solve();
        }
    }
}
