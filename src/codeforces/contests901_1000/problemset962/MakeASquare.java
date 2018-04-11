package codeforces.contests901_1000.problemset962;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;
import static java.lang.Math.sqrt;

public class MakeASquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String s = String.valueOf(n);
        int size = s.length(), result = 15;
        int MAX = (1 << (size + 1)) - 1;
        for (int mask = 0; mask <= MAX; mask++) {
            StringBuilder value = new StringBuilder();
            for (int j = size - 1; j >= 0; j--) {
                if ((mask & (1 << j)) == 0) {
                    value.append(s.charAt(size - j - 1));
                }
            }
            String remaining = value.toString();
            if (valid(remaining)) {
                int x = Integer.valueOf(remaining), sqrt = (int) sqrt(x);
                if (sqrt * sqrt == x) {
                    result = Math.min(bitCount(mask), result);
                }
            }
        }
        out.println(result == 15 ? -1 : result);
    }

    private boolean valid(String s) {
        return s.length() > 0 && s.charAt(0) != '0';
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
        try (MakeASquare instance = new MakeASquare()) {
            instance.solve();
        }
    }
}
