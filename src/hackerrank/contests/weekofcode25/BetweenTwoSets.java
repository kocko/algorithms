package hackerrank.contests.weekofcode25;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BetweenTwoSets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        int x = in.ni();
        for (int i = 1; i < n; i++) {
            x = lcm(x, in.ni());
        }
        int y = in.ni();
        for (int i = 1; i < m; i++) {
            y = gcd(y, in.ni());
        }
        int result = 0;
        if (y >= x && y % x == 0) {
            for (int i = 1; i <= (y / x); i++) {
                if (y % (x * i) == 0) result++;
            }
        }
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
        try (BetweenTwoSets instance = new BetweenTwoSets()) {
            instance.solve();
        }
    }
}
