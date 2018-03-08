package codeforces.contests901_1000.problemset940;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class OurTanyaIsCryingOutLoud implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), k = in.nl(), a = in.nl(), b = in.nl(), result = 0L;
        if (k == 1) {
            result = (n - 1) * a;
        } else {
            while (n > 1) {
                if (n >= k) {
                    long rem = n % k;
                    if (rem == 0) {
                        long times = n - (n / k);
                        result += min(times * a, b);
                        n /= k;
                    } else {
                        n -= rem;
                        result += rem * a;
                    }
                } else {
                    result += (n - 1) * a;
                    n = 1;
                }
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
        try (OurTanyaIsCryingOutLoud instance = new OurTanyaIsCryingOutLoud()) {
            instance.solve();
        }
    }
}
