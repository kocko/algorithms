package codeforces.contests601_700.problemset678;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JotyAndChocolate implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public void solve() {
        long n = in.nl(), a = in.nl(), b = in.nl(), p = in.nl(), q = in.nl();
        long result = n / a * p + n / b * q - n / lcm(a, b) * Math.min(p, q);
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
        try (JotyAndChocolate instance = new JotyAndChocolate()) {
            instance.solve();
        }
    }
}
