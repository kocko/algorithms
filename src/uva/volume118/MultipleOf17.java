package uva.volume118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class MultipleOf17 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final BigInteger FIVE = valueOf(5), MINUS_ONE = valueOf(~0), SEVENTEEN = valueOf(17);
        String number;
        while (!"0".equals(number = in.next())) {
            BigInteger value = new BigInteger(number);
            BigInteger remainder = value.remainder(TEN);
            value = value.divide(TEN);
            value = value.add(remainder.multiply(FIVE).multiply(MINUS_ONE));
            if (value.remainder(SEVENTEEN).equals(ZERO)) {
                out.println(1);
            } else {
                out.println(0);
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
        try (MultipleOf17 instance = new MultipleOf17()) {
            instance.solve();
        }
    }
}
