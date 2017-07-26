package uva.volume112;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KTV implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int test = 1;
        int n;
        while ((n = in.ni()) != 0) {
            dp = new int[1 << 9];
            table = new int[9][9][9];
            for (int i = 0; i < n; i++) {
                int x = in.ni() - 1, y = in.ni() - 1, z = in.ni() - 1, value = in.ni();
                table[x][y][z] = table[x][z][y] = table[y][x][z] = table[y][z][x] = table[z][x][y] = table[z][y][x] = value; 
            }
            for (int i = 0; i < dp.length; i++) dp[i] = -1;
            int ans = recurse(0);
            out.printf("Case %d: %d\n", test++, (ans > 0 ? ans : -1));
        }
    }
    
    private final int INF = 1 << 20;
    private int[] dp;
    private int[][][] table;
    
    private int recurse(int mask) {
        if (Integer.bitCount(mask) == 9) return 0;
        
        if (dp[mask] != -1) return dp[mask];
        
        int ans = -INF;
        for (int i = 0; i < 9; i++) if ((mask & (1 << i)) == 0) {
            for (int j = i + 1; j < 9; j++) if ((mask & (1 << j)) == 0) {
                for (int k = j + 1; k < 9; k++) if ((mask & (1 << k)) == 0) {
                    if (table[i][j][k] > 0) {
                        int nmask = mask | (1 << i) | (1 << j) | (1 << k);
                        ans = Math.max(ans, recurse(nmask) + table[i][j][k]);
                    }
                }
            }
        }
        
        return dp[mask] = ans;
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
        try (KTV instance = new KTV()) {
            instance.solve();
        }
    }
}
