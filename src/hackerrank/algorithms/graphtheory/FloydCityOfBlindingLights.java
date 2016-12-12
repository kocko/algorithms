package hackerrank.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FloydCityOfBlindingLights implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        final int INF = 10000009;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dp[i][j] = 0;
                else dp[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = in.ni(), y = in.ni(), w = in.ni();
            dp[x - 1][y - 1] = w;
        }
        for (int k = 0; k < n; k++) for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        int q = in.ni();
        while (q-- > 0) {
            int result = dp[in.ni() - 1][in.ni() - 1];
            out.println(result == INF ? -1 : result);
        }
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
        try (FloydCityOfBlindingLights instance = new FloydCityOfBlindingLights()) {
            instance.solve();
        }
    }
}
