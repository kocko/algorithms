package uva.volume103;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Square implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int tests = in.ni();
        while (tests-- > 0) {
            n = in.ni();
            size = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                size[i] = in.ni();
                total += size[i];
            }
            if (total % 4 == 0) {
                dp = new Boolean[1 << n];
                target = total / 4;
                out.println(recurse(0, 0) ? "yes" : "no");
            } else {
                out.println("no");
            }
        }
    }
    
    private int n, target;
    private int[] size;
    private Boolean[] dp;
    
    private boolean recurse(int mask, int sum) {
        if (sum > target) return false;
        if (sum % target == 0) sum = 0;
        if (Integer.bitCount(mask) == n) {
            return sum % target == 0;
        }
        
        if (dp[mask] != null) return dp[mask];

        boolean ans = false;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                ans |= recurse(mask | (1 << i), sum + size[i]);
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
        try (Square instance = new Square()) {
            instance.solve();
        }
    }
}
