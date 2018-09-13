package codeforces.contests1001_1100.problemset1025;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WeakenedCommonDivisor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = in.ni();
            pairs[i][1] = in.ni();
        }
        Set<Integer> divisors = new TreeSet<>();
        for (int i = 0; i < 2; i++) {
            int k = pairs[0][i];
            for (int j = 2; j * j <= k; j++) {
                while (k % j == 0) {
                    divisors.add(j);
                    k /= j;
                }
            }
            if (k > 1) {
                divisors.add(k);
            }
        }
        for (int div : divisors) {
            boolean ok = true;
            for (int i = 1; i < n; i++) {
                ok &= (pairs[i][0] % div == 0 || pairs[i][1] % div == 0); 
            }
            if (ok) {
                out.println(div);
                return;
            }
        }
        out.println(-1);
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
        try (WeakenedCommonDivisor instance = new WeakenedCommonDivisor()) {
            instance.solve();
        }
    }
}
