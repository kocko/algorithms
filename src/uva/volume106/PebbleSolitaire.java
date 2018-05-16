package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PebbleSolitaire implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        while (n-- > 0) {
            char[] x = in.next().toCharArray();
            dp = new int[1 << 15];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = -1;
            }
            int mask = 1 << 13;
            int count = 0;
            for (int i = 0; i < 12; i++) {
                if (x[11 - i] == 'o') {
                    count++;
                    mask |= (1 << i);
                }
            }
            out.println(count - recurse(mask));
        }
    }

    private int[] dp;
    
    private int recurse(int mask) {
        if (dp[mask] != -1) return dp[mask];
        
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if ((mask & (1 << i)) != 0 && 
                (mask & (1 << (i + 1))) != 0 && 
                (mask & (1 << (i + 2))) == 0) {
                int newMask = mask;
                newMask ^= (1 << i);
                newMask ^= (1 << (i + 1));
                newMask |= (1 << (i + 2));
                score = Math.max(score, 1 + recurse(newMask));
            }
        }
        for (int i = 11; i >= 2; i--) {
            if ((mask & (1 << i)) != 0 &&
                (mask & (1 << (i - 1))) != 0 &&
                (mask & (1 << (i - 2))) == 0) {
                int newMask = mask;
                newMask ^= (1 << i);
                newMask ^= (1 << (i - 1));
                newMask |= (1 << (i - 2));
                score = Math.max(score, 1 + recurse(newMask));
            }
        }
        
        return dp[mask] = score;
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
        try (PebbleSolitaire instance = new PebbleSolitaire()) {
            instance.solve();
        }
    }
}
