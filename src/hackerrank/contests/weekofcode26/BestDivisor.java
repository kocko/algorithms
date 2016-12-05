package hackerrank.contests.weekofcode26;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BestDivisor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> divisors = findDivisors(n);
        int max = 0;
        int result = -1;
        for (Integer d : divisors) {
            int score = score(d);
            if (score > max) {
                result = d;
                max = score;
            } else if (score == max) {
                result = Math.min(d, result);
            }
        }
        out.println(result);
    }

    private int score(int d) {
        int result = 0;
        String x = String.valueOf(d);
        for (char c : x.toCharArray()) {
            result += (c - '0');
        }
        return result;
    }
    
    private List<Integer> findDivisors(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(n);
        result.add(1);
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != (n / i)) {
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
        try (BestDivisor instance = new BestDivisor()) {
            instance.solve();
        }
    }
}
