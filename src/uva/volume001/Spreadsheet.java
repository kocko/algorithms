package uva.volume001;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Spreadsheet implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int m = in.ni(), n = in.ni();
            grid = new String[n + 1][m + 1];
            dp = new Integer[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    grid[i][j] = in.next();
                    if (grid[i][j].charAt(0) != '=') {
                        dp[i][j] = parseInt(grid[i][j]);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (grid[i][j].charAt(0) == '=') {
                        recurse(i, j);
                    }
                    out.print(dp[i][j]);
                    if (j < m) {
                        out.print(' ');
                    }
                }
                out.println();
            }
        }
    }

    private String[][] grid;
    private Integer[][] dp;

    private int recurse(int row, int col) {
        if (dp[row][col] != null) return dp[row][col];

        int ans = 0;
        if (grid[row][col].charAt(0) == '=') {
            String[] formula = grid[row][col].substring(1).split("\\+");
            for (String cell : formula) {
                int[] coordinates = findCoordinates(cell);
                ans += recurse(coordinates[0], coordinates[1]);
            }
        } else {
            ans = parseInt(grid[row][col]);
        }

        return dp[row][col] = ans;
    }

    private int[] findCoordinates(String value) {
        char[] x = value.toCharArray();
        int[] result = new int[2];
        int idx = -1;
        while (++idx < x.length) {
            if (x[idx] >= 'A' && x[idx] <= 'Z') {
                result[1] *= 26;
                result[1] += (x[idx] - 'A') + 1;
            } else {
                result[0] *= 10;
                result[0] += x[idx] - '0';
            }
        }
        return result;
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
            return parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (Spreadsheet instance = new Spreadsheet()) {
            instance.solve();
        }
    }
}
