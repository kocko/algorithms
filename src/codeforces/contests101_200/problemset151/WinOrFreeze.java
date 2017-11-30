package codeforces.contests101_200.problemset151;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinOrFreeze implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        if (n == 1) {
            out.println(1);
            out.println(0);
            return;
        }
        List<Long> factors = factorize(n);
        if (factors.size() == 1) {
            out.println(1);
            out.println(0);
        } else {
            if (factors.size() > 2) {
                out.println(1);
                out.println(factors.get(0) * factors.get(1));
            } else {
                out.println(2);
            }
        }
    }
    
    private List<Long> factorize(long n) {
        List<Long> result = new ArrayList<>();
        for (long i = 2L; i * i <= n ; i++) {
            while (n % i == 0) {
                result.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            result.add(n);
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
        try (WinOrFreeze instance = new WinOrFreeze()) {
            instance.solve();
        }
    }
}
