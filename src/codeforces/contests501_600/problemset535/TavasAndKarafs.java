package codeforces.contests501_600.problemset535;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class TavasAndKarafs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        a = in.nl();
        b = in.ni();
        int q = in.ni();
        while (q-- > 0) {
            long l = in.nl(), t = in.nl(), m = in.nl();
            if (a + (l - 1) * b > t * m) {
                out.println(-1);
            } else {
                long left = l, right = 3000001, result = -1;
                while (left <= right) {
                    long mid = left + (right - left) / 2L;
                    long max = a + (mid - 1) * b;
                    long sum = sum(l, mid);
                    if (max <= t && sum <= m * t) {
                        result = max(result, mid);
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                out.println(result);
            }
        }
    }

    private long a, b;
    
    private long sum(long left, long right) {
        return sum(right) - sum(left - 1);
    }

    private long sum(long n) {
        return n * a + ((n * (n - 1)) / 2L) * b;
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
        try (TavasAndKarafs instance = new TavasAndKarafs()) {
            instance.solve();
        }
    }
}
