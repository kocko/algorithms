package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DivisibleSumPairs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] rem = new int[k];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            rem[next % k]++;
        }
        long result = 0;
        for (int i = 1; i < k; i++) {
            if (i != k - i) {
                result += rem[i] * rem[k - i];
            } else {
                if (rem[i] != 0) {
                    result += (rem[i] - 1) * rem[i];
                }
            }
        }
        if (rem[0] != 0) {
            result += rem[0] * (rem[0] - 1);
        }
        out.println(result >> 1);
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
        try (DivisibleSumPairs instance = new DivisibleSumPairs()) {
            instance.solve();
        }
    }
}
