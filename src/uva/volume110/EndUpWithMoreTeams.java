package uva.volume110;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class EndUpWithMoreTeams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 0;
        while ((n = in.ni()) != 0) {
            x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            dp = new Integer[1 << n];
            out.printf("Case %d: %d\n", ++testCase, recurse(0));
        }
    }

    private int n;
    private int[] x;
    private Integer[] dp;

    private int recurse(int mask) {
        if (dp[mask] != null) return dp[mask];

        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) == 0) {
                        for (int k = 0; k < n; k++) {
                            if ((mask & (1 << k)) == 0) {
                                if (i != j && j != k && i != k && x[i] + x[j] + x[k] >= 20) {
                                    result = max(result, 1 + recurse(mask | (1 << i) | (1 << j) | (1 << k)));
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[mask] = result;
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
        try (EndUpWithMoreTeams instance = new EndUpWithMoreTeams()) {
            instance.solve();
        }
    }
}
