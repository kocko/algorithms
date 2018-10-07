package codeforces.contests1001_1100.problemset1033;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SquareDifference implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        while (t-- > 0) {
            BigInteger a = BigInteger.valueOf(in.nl()), b = BigInteger.valueOf(in.nl());
            BigInteger rem = a.add(b.multiply(MINUS_ONE)).multiply(a.add(b));
            if (rem.isProbablePrime(1)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
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
        try (SquareDifference instance = new SquareDifference()) {
            instance.solve();
        }
    }
}
