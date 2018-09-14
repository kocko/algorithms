package hackerearth.search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.valueOf;
import static java.lang.Math.*;

public class Rescuer implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            x1 = in.nl(); y1 = in.nl();
            x2 = in.nl(); y2 = in.nl();
            v1 = valueOf(in.next());
            v2 = valueOf(in.next());
            double result = time(ternarySearch());
            out.printf("%.5f\n", result);
        }
    }

    private long x1, y1, x2, y2;
    private double v1, v2;
    
    private double ternarySearch() {
        final double PHI = 1.618033988749895;
        double eps = 1e-5;
        double left = x1, right = x2;
        while (abs(right - left) > eps) {
            double m1 = left  + (right - left) / PHI;
            double m2 = right - (right - left) / PHI;
            if (time(m1) < time(m2)) {
                left = m2;
            } else {
                right = m1;
            }
        }
        return (left + right) / 2.;
    }
    
    private double time(double _x) {
        return sqrt((_x - x1) * (_x - x1) + y1 * y1) / v1 + (sqrt((_x - x2) * (_x - x2) + y2 * y2) / v2);
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
        try (Rescuer instance = new Rescuer()) {
            instance.solve();
        }
    }
}
