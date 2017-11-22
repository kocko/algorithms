package codeforces.contests201_300.problemset225;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Barcode implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        x = in.ni();
        y = in.ni();
        char[][] barcode = new char[n][m];
        for (int i = 0; i < n; i++) {
            barcode[i] = in.next().toCharArray();
        }
        int[] white = new int[m];
        for (int j = 0; j < m; j++) {
            int b = 0;
            for (int i = 0; i < n; i++) {
                if (barcode[i][j] == '#') b++;
            }
            white[j] = b;
        }
        prefix = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            prefix[i] = prefix[i - 1] + white[i - 1];
        }
        dp = new int[m][2];
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        out.println(min(recurse(0, 0), recurse(0, 1)));
    }
    
    private int n, m, x, y;
    private int[] prefix;
    
    private int[][] dp;
    
    private int recurse(int column, int color) {
        if (column >= m) return 0;
        if (dp[column][color] != -1) return dp[column][color];
        
        int ans = (int) 1e8;
        for (int i = x; i <= y && column + i <= m; i++) {
            int whites = prefix[column + i] - prefix[column];
            int blacks = n * i - whites;
            int cost;
            if (color == 1) {
                cost = whites;
            } else {
                cost = blacks;
            }
            ans = min(ans, cost + recurse(column + i, color ^ 1));
        }
        return dp[column][color] = ans;
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
        try (Barcode instance = new Barcode()) {
            instance.solve();
        }
    }
}
