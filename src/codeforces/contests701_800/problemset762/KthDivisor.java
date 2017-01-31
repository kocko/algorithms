package codeforces.contests701_800.problemset762;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class KthDivisor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        List<Long> divisors = findDivisors(n);
        Collections.sort(divisors);
        int k = in.ni() - 1;
        if (k >= divisors.size()) {
            out.println(-1);
        } else {
            out.println(divisors.get(k));
        }
    }
    
    private List<Long> findDivisors(long n) {
        List<Long> result = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                result.add((long) i);
                if (n / i != i) {
                    result.add(n / i);
                }
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
        try (KthDivisor instance = new KthDivisor()) {
            instance.solve();
        }
    }
}
