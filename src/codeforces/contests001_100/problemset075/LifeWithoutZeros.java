package codeforces.contests001_100.problemset075;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LifeWithoutZeros implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long a = in.nl(), b = in.ni(), c = a + b;
        a = removeZeroes(a);
        b = removeZeroes(b);
        c = removeZeroes(c);
        out.println((a + b == c) ? "YES" : "NO");
    }
    
    private long removeZeroes(long x) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            if (x % 10 != 0) {
                sb.append(x % 10);
            }
            x /= 10;
        }
        return Long.valueOf(sb.reverse().toString());
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
        try (LifeWithoutZeros instance = new LifeWithoutZeros()) {
            instance.solve();
        }
    }
}
