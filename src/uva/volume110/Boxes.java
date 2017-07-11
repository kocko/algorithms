package uva.volume110;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class Boxes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while ((n = in.ni()) != 0) {
            weight = new int[n];
            max = new int[n];
            dp = new int[n][3001];
            for (int i = 0; i < n; i++) {
                weight[i] = in.ni();
                max[i] = in.ni();
                Arrays.fill(dp[i], -1);
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = max(result, recurse(i + 1, max[i]) + 1);
            }
            out.println(result);
        }
    }
    
    private int n;
    private int[] weight;
    private int[] max;
    private int[][] dp;
    
    private int recurse(int idx, int limit) {
        if (idx == n) return 0;
        
        if (dp[idx][limit] != -1) return dp[idx][limit];
        
        int ans = recurse(idx + 1, limit);
        if (weight[idx] <= limit) {
            ans = max(ans, 1 + recurse(idx + 1, min(limit - weight[idx], max[idx])));
        }
        
        return dp[idx][limit] = ans;
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
        try (Boxes instance = new Boxes()) {
            instance.solve();
        }
    }
}
