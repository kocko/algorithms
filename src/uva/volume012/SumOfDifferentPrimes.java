package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SumOfDifferentPrimes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        for (int[][] table : dp) {
            for (int[] row : table) {
                Arrays.fill(row, -1);
            }
        }
        eratosthenes();
        int n, k;
        while ((n = in.ni()) != 0 && (k = in.ni()) != 0) {
            out.println(recurse(n, k, 0));
        }
    }
    
    private final int MAX = 1121;
    private int[][][] dp = new int[MAX][15][188];
    private List<Integer> primes = new ArrayList<>();
    
    private void eratosthenes() {
        boolean[] prime = new boolean[MAX];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
                primes.add(i);
            }
        }
    }
    
    private int recurse(int sum, int count, int idx) {
        if (sum == 0 && count == 0) return 1;
        if (sum < 0 || count < 0) return 0;
        if (idx >= 187) return 0;
        
        if (dp[sum][count][idx] != -1) return dp[sum][count][idx];
        
        int ans = 0;
        int value = primes.get(idx);
        if (sum >= value) {
            ans = recurse(sum, count, idx + 1) + recurse(sum - value, count - 1, idx + 1);
        }
        return dp[sum][count][idx] = ans;
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
        try (SumOfDifferentPrimes instance = new SumOfDifferentPrimes()) {
            instance.solve();
        }
    }
}
