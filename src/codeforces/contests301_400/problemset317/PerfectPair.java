package codeforces.contests301_400.problemset317;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PerfectPair implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long x = in.nl(), y = in.nl(), m = in.nl();
        out.println(find(x, y, m));
    }
    
    private long find(long x, long y, long m) {
        if (x >= m || y >= m) return 0;
        if (x <= 0 && y <= 0) return -1;
        if (x > 0 && y > 0) return loop(x, y, m);
        long result = 0;
        if (x > 0 && y < 0) {
            long t = x;
            x = y;
            y = t;
        }
        result += ((Math.abs(x) + Math.abs(y) - 1) / Math.abs(y));
        x += result * y;
        while (x < m && y < m) {
            if (x < y) {
                x += y;
            } else {
                y += x;
            }
            result++;
        }
        return result;
    }

    private int loop(long x, long y, long m) {
        long max = Math.max(x, y);
        if (m <= max) return 0;
        int count = 0;
        while (m > max) {
            long temp = Math.max(x, y);
            x = (x + y);
            y = temp;
            max = Math.max(x, y);
            count++;
        }
        return count;
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
        try (PerfectPair instance = new PerfectPair()) {
            instance.solve();
        }
    }
}
