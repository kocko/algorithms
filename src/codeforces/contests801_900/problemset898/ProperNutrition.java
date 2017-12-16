package codeforces.contests801_900.problemset898;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProperNutrition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), a = in.nl(), b = in.nl(), gcd = gcd(a, b);
        if (n % gcd != 0) {
            out.println("NO");
        } else {
            for (int x = 0; x <= n; x++) {
                long t = n - a * x;
                if (t < 0) {
                    out.println("NO");
                    return;
                }
                if (t == 0 || (t >= b && t % b == 0)) {
                    out.println("YES");
                    out.print(x + " " + (t / b));
                    return;
                }
            }
        }
    }

    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
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
        try (ProperNutrition instance = new ProperNutrition()) {
            instance.solve();
        }
    }
}
