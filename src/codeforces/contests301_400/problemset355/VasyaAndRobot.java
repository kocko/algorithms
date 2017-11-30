package codeforces.contests301_400.problemset355;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class VasyaAndRobot implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), l = in.ni(), r = in.ni(), ql = in.ni(), qr = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = x[i];
            if (i > 0) prefix[i] += prefix[i - 1];
        }
        int result = Integer.MAX_VALUE;
        for (int right = 0; right <= n; right++) {
            int left = n - right;
            int score;
            if (left > 0) {
                score = prefix[left - 1] * l + (prefix[n - 1] - prefix[left - 1]) * r;
            } else {
                score = prefix[n - 1] * r;
            }
            int q;
            if (left == right) {
                q = 0;
            } else {
                q = left > right ? ql : qr;
            }
            int diff = abs(left - right) - 1;
            score += q * diff;
            if (score < result) result = score;
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
        try (VasyaAndRobot instance = new VasyaAndRobot()) {
            instance.solve();
        }
    }
}
