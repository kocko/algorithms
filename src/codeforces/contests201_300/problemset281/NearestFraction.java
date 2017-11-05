package codeforces.contests201_300.problemset281;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NearestFraction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long x = in.nl(), y = in.nl(), n = in.nl();
        Double min = Double.POSITIVE_INFINITY;
        long[] result = new long[2];
        for (long denominator = 1; denominator <= n; denominator++) {
            long a = denominator * x / y;
            for (long mid = a; mid < a + 60; mid++) {
                double diff = Math.abs(((double) mid / denominator) - ((double) x / y));
                if (diff < min && Math.abs(diff - min) > 1e-15) {
                    min = diff;
                    result[0] = mid;
                    result[1] = denominator;
                }
            }
        }
        out.println(result[0] + "/" + result[1]);
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
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
        try (NearestFraction instance = new NearestFraction()) {
            instance.solve();
        }
    }
}
