package codeforces.contests801_900.problemset888;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlmostIdentityPermutations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), k = in.nl(), result = 0;
        int[] d = {1, 0, 1, 2, 9};
        for (int m = 0; m <= k; m++) {
            result += c(n, m) * d[m];
        }
        out.println(result);
    }

    private long c(long n, long k) {
        long result = 1L;
        for (long i = n, j = 1; i >= n - k + 1 && j <= k; i--, j++) {
            result *= i;
            result /= j;
        }
        return result;
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
        try (AlmostIdentityPermutations instance = new AlmostIdentityPermutations()) {
            instance.solve();
        }
    }
}
