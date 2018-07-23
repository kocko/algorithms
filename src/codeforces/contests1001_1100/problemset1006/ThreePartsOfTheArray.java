package codeforces.contests1001_1100.problemset1006;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreePartsOfTheArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] x = new long[n], prefix = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
            prefix[i] = x[i];
            if (i > 0) prefix[i] += prefix[i - 1];
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            long s1 = prefix[i];
            int left = i + 1, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long s3 = prefix[n - 1] - prefix[mid - 1];
                if (s3 < s1) {
                    right = mid - 1;
                } else if (s3 > s1) {
                    left = mid + 1;
                } else {
                    result = s1;
                    break;
                }
            }
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

    public static void main(String[] args) throws IOException {
        try (ThreePartsOfTheArray instance = new ThreePartsOfTheArray()) {
            instance.solve();
        }
    }
}
