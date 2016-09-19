package hackerrank.contests.weekofcode23;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class TreasureHunting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        long x = in.nl(), y = in.nl(), a = in.nl(), b = in.nl();
        double k = (double) (a * y - x * b) / (a * a + b * b);
        double n = (x + k * b) / a;
        out.println(new BigDecimal(n).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
        out.println(new BigDecimal(k).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
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
        try (TreasureHunting instance = new TreasureHunting()) {
            instance.solve();
        }
    }
}
