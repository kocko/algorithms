package hackerearth.basic.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumOfNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        tests: while (t-- > 0) {
            int n = in.ni();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            int aim = in.ni();
            if (aim == 0) {
                out.println("YES");
                continue;
            }
            int limit = (1 << n) - 1;
            for (int b = 1; b <= limit; b++) {
                char[] binary = Integer.toBinaryString(b).toCharArray();
                long sum = 0L;
                int k = binary.length;
                for (int offset = 0; offset < k; offset++) {
                    if (binary[k - offset - 1] == '1') {
                        sum += x[n - offset - 1];
                    }
                }
                if (sum == aim) {
                    out.println("YES");
                    continue tests;
                }
            }
            out.println("NO");
        }
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
        try (SumOfNumbers instance = new SumOfNumbers()) {
            instance.solve();
        }
    }
}
