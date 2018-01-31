package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XorSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            long left = in.nl(), right = in.nl();
            out.println(f(right) ^ f(left - 1));
        }
    }

    private long f(long n) {
        long result = 0L, count;
        if (n % 2 == 1) {
            count = (n + 1) / 2L;
            if (count % 2 == 1) {
                result |= 1L;
            }
        } else {
            count = (n + 2) / 2L;
        }
        if (n >= 2 && (count / 2) % 2 == 1) {
            result |= 2L;
        }
        for (int i = 2; (1L << i <= n); i++) {
            long bit = (1L << i);
            long ones = 0, rem = count % bit;
            if (rem > (bit >> 1)) {
                ones += rem - (bit >> 1);
            }
            if (ones % 2 == 1) {
                result |= bit;
            }
        }
        return result;
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
        try (XorSequence instance = new XorSequence()) {
            instance.solve();
        }
    }
}
