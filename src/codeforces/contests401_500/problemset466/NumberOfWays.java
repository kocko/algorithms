package codeforces.contests401_500.problemset466;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberOfWays implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        long[] prefix = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long next = in.ni();
            prefix[i] = next;
            if (i != 0) {
                prefix[i] += prefix[i - 1];
            }
            sum += next;
        }
        if (sum % 3 != 0) {
            out.println(0); return;
        }
        long limit = sum / 3;
        long count = 0, result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == limit * 2) result += count;
            if (prefix[i] == limit) count++;
        }
        out.println(result);
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

    public static void main(String[] args) {
        new NumberOfWays().solve();
    }
}
