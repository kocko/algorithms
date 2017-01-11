package codeforces.contests401_500.problemset489;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GivenLengthAndSumOfDigits implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int n;
    private int sum;
    private String[][] dp;
    
    public void solve() {
        n = in.ni();
        sum = in.ni();
        if (sum == 0 && n == 1) {
            out.println("0 0");
        } else if (9 * n < sum || sum == 0) {
            out.println("-1 -1");
        } else {
            dp = new String[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    dp[i][j] = dp[i][j] = "";
                }
            }
            maximize(0, 0);
            out.println(minimize(dp[n][sum]) + " " + dp[n][sum]);
        }
    }
    
    private void maximize(int idx, int s) {
        if (idx == n) return;
        if (s == sum) {
            dp[idx + 1][s] = dp[idx][s] + '0';
            maximize(idx + 1, s);
            return;
        }

        if (s + 9 <= sum) {
            dp[idx + 1][s + 9] = dp[idx][s] + '9';
            maximize(idx + 1, s + 9);
        } else {
            dp[idx + 1][sum] = dp[idx][s] + (sum - s);
            maximize(idx + 1, sum);
        }
    }
    
    private String minimize(String s) {
        char[] x = new StringBuilder(s).reverse().toString().toCharArray();
        if (x[0] == '0') {
            int i;
            for (i = 0; i < x.length; i++) {
                if (x[i] != '0') break;
            }   
            char d = x[i];
            x[i] = '0';
            x[0] = d;
            while (x[0] > '1' && x[i] < '9') {
                x[0]--;
                x[i]++;
            }
        }
        return new String(x);
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
        try (GivenLengthAndSumOfDigits instance = new GivenLengthAndSumOfDigits()) {
            instance.solve();
        }
    }
}
