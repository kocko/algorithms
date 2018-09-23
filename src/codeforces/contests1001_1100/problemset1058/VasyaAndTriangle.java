package codeforces.contests1001_1100.problemset1058;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class VasyaAndTriangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), m = in.nl(), k = in.nl(), x, y;
        long gcd = gcd(n, k);
        x = n / gcd;
        k /= gcd;

        gcd = gcd(m, k);
        y = m / gcd;
        k /= gcd;

        if (k > 2) {
            out.println("NO");
            return;
        }
        if (k == 1) {
            if (x * 2 <= n) {
                x *= 2;
            } else if (y * 2 <= m){
                y *= 2;
            }
        }
        out.println("YES");
        out.println("0 0");
        out.println(x + " 0");
        out.println("0 " + y);
    }

    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
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
        try (VasyaAndTriangle instance = new VasyaAndTriangle()) {
            instance.solve();
        }
    }
}
