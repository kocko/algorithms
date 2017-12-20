package uva.volume103;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.cos;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class FlightPlanner implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            dp = new long[10][n / 100];
            cost = new long[10][n / 100];
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < n / 100; j++) {
                    cost[i][j] = in.nl();
                    dp[i][j] = -1;
                }
            }
            out.println(recurse(0, 0));
            out.println();
        }
    }
    
    private long[][] dp;
    private long[][] cost;
    
    private long recurse(int altitude, int idx) {
        if (idx == cost[0].length) {
            if (altitude == 0) {
                return 0;
            } else {
                return (long) 1e9;
            }
        }
        if (dp[altitude][idx] != -1) return dp[altitude][idx];
        
        long ans = 30 - cost[altitude][idx] + recurse(altitude, idx + 1);
        if (altitude < 9) {
            ans = min(ans, 60 - cost[altitude][idx] + recurse(altitude + 1, idx + 1));
        }
        if (altitude > 0) {
            ans = min(ans, 20 - cost[altitude][idx] + recurse(altitude - 1, idx + 1));
        }
        return dp[altitude][idx] = ans;
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
        try (FlightPlanner instance = new FlightPlanner()) {
            instance.solve();
        }
    }
}
