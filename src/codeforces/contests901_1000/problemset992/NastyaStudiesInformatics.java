package codeforces.contests901_1000.problemset992;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NastyaStudiesInformatics implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long left = in.nl(), right = in.nl(), x = in.nl(), y = in.nl(), result = 0;
        if (y % x != 0) {
            out.println(0);return;
        } else {
            long max = y / x;
            for (int d = 1; d * d <= max; d++) {
                if (max % d == 0) {
                    long c = max / d;
                    if (left <= c * x && c * x <= right && left <= d * x && d * x <= right && gcd(c, d) == 1) {
                        if (d * d == max) result++;
                        else result += 2;
                    }
                }
            }
        }
        out.println(result);
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
        try (NastyaStudiesInformatics instance = new NastyaStudiesInformatics()) {
            instance.solve();
        }
    }
}
