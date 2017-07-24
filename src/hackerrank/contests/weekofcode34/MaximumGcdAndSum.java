package hackerrank.contests.weekofcode34;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumGcdAndSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        int n = 1000000;
        int[] a = new int[n + 1], b = new int[n + 1];
        for (int i = 1; i <= t; i++) a[i] = in.ni();
        for (int i = 1; i <= t; i++) b[i] = in.ni();
        int[] cnt_a = new int[n + 1];
        int[] mul_a = new int[n + 1];
        int[] cnt_b = new int[n + 1];
        int[] mul_b = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            cnt_a[a[i]]++;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                if (cnt_a[j] > 0) {
                    mul_a[i] = j;
                }
            }
        }
        for (int i = 1; i <= n; ++i) {
            cnt_b[b[i]]++;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                if (cnt_b[j] > 0) {
                    mul_b[i] = j;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            if (mul_a[i] > 0 && mul_b[i] > 0) {
                max = i;
            }
        }
        out.println(mul_a[max] + mul_b[max]);
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
        try (MaximumGcdAndSum instance = new MaximumGcdAndSum()) {
            instance.solve();
        }
    }
}
