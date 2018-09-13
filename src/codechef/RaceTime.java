package codechef;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RaceTime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        int k = in.ni();
        s = new long[n];
        d = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nl();
            d[i] = in.nl();
        }
        double left = 0, right = k;
        double eps = 1e-12;
        while (right - left > eps) {
            double m1 = (2 * left + right) / 3.;
            double m2 = (2 * right + left) / 3.;
            double p = f(m1), q = f(m2);
            if (p < q) {
                right = m2;
            } else {
                left = m1;
            }
        }
        out.printf("%.6f", (double) f(left));
    }
    
    private int n;
    private long[] s, d;
    
    private double f(double t) {
        double max = 0, min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double pos = s[i] * t + d[i];
            max = max(max, pos);
            min = min(min, pos);
        }
        return max - min;
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
        try (RaceTime instance = new RaceTime()) {
            instance.solve();
        }
    }
}
