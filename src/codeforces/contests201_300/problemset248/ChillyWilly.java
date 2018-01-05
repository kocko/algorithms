package codeforces.contests201_300.problemset248;

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

public class ChillyWilly implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n < 3) {
            out.println(-1);
        } else if (n == 3) {
            out.println(210);
        } else {
            int power = n - 1;
            BigInteger result = TEN.pow(power);
            BigInteger _210 = BigInteger.valueOf(210);
            BigInteger rem = result.remainder(_210);
            BigInteger add = _210.add(rem.multiply(BigInteger.valueOf(-1)));
            out.println(result.add(add));
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
        try (ChillyWilly instance = new ChillyWilly()) {
            instance.solve();
        }
    }
}
