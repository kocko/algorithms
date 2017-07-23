package uva.volume109;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FormingQuizTeams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int test = 1;
        while ((n = in.ni()) != 0) {
            n <<= 1;
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                in.next();
                x[i] = in.ni();
                y[i] = in.ni();
            }
            dist = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dist[i][j] = dist[j][i] = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                }
            }
            dp = new double[1 << n];
            Arrays.fill(dp, -1);
            double ans = recurse(0);
            DecimalFormat df = new DecimalFormat("#.##");
            out.printf("Case %d: %.2f\n", test++, Double.valueOf(df.format(ans)));
        }
    }

    private final double INF = 1e9;
    private int n;
    private double[][] dist;
    private double[] dp;

    private double recurse(int mask) {
        if (Integer.bitCount(mask) == n) return 0;
        if (dp[mask] != -1) return dp[mask];

        double ans = INF;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int nmask = mask | (1 << i) | (1 << j);
                        ans = Math.min(ans, dist[i][j] + recurse(nmask));
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
        try (FormingQuizTeams instance = new FormingQuizTeams()) {
            instance.solve();
        }
    }
}
