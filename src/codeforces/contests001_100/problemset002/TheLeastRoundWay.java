package codeforces.contests001_100.problemset002;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheLeastRoundWay implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new int[n][n];
        dp = new int[n][n][2];
        best = new char[n][n][2];
        boolean hasZero = false;
        int row = -1, col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = in.ni();
                if (x[i][j] == 0) {
                    hasZero = true;
                    row = i;
                    col = j;
                    x[i][j] = 10;
                }
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = 10001;
        String path = "";
        if (hasZero) {
            ans = 1;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < row; i++) {
                builder.append('D');
            }
            for (int i = 1; i < n; i++) {
                builder.append('R');
            }
            for (int i = row + 1; i < n; i++) {
                builder.append('D');
            }
            path = builder.toString();
        }
        int twos = recurse(n - 1, n - 1, 0);
        int fives = recurse(n - 1, n - 1, 1);
        if (Math.min(twos, fives) < ans) {
            if (twos < fives) {
                ans = twos;
                path = fetchPath(0);
            } else {
                ans = fives;
                path = fetchPath(1);
            }
        }
        out.println(ans);
        out.println(path);
    }
    
    private int n;
    private int[][] x;
    private int[][][] dp;
    private char[][][] best;
    
    private int recurse(int i, int j, int idx) {
        if (i < 0 || j < 0) return -1;
        
        if (dp[i][j][idx] != -1) return dp[i][j][idx];
        
        int ans = get(x[i][j], idx == 0 ? 2 : 5);
        int up = recurse(i - 1, j, idx), left = recurse(i, j - 1, idx);
        if (up != -1 && left != -1) {
            if (up > left) {
                ans += left;
                best[i][j][idx] = 'L';
            } else {
                ans += up;
                best[i][j][idx] = 'U';
            }
        } else if (up != -1) {
            ans += up;
            best[i][j][idx] = 'U';
        } else if (left != -1) {
            ans += left;
            best[i][j][idx] = 'L';
        }
        return dp[i][j][idx] = ans;
    }
    
    private int get(int n, int k) {
        int result = 0;
        while (n % k == 0) {
            n /= k;
            result++;
        }
        return result;
    }
    
    private String fetchPath(int idx) {
        StringBuilder builder = new StringBuilder();
        int i = n - 1, j = n - 1;
        while (i > 0 || j > 0) {
            char value = best[i][j][idx];
            if (value == 'L') {
                value = 'R';
                j--;
            }
            if (value == 'U') {
                value = 'D';
                i--;
            } 
            builder.append(value);
        }
        return builder.reverse().toString();
    }
    
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (TheLeastRoundWay instance = new TheLeastRoundWay()) {
            instance.solve();
        }
    }
}
