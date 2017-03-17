package codeforces.contests701_800.problemset770;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximizeSumOfDigits implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int sum = 0;
        for (char c : x) {
            sum += (c - '0');
        }
        String result = new String(x);
        for (int i = n - 1; i >= 0; i--) {
            char[] d = new char[n];
            System.arraycopy(x, 0, d, 0, n);
            if (d[i] > '0') {
                d[i]--;
                for (int j = i + 1; j < n; j++) {
                    d[j] = '9';
                }
                int current = 0;
                for (char c : d) {
                    current += (c - '0');
                }
                if (current > sum) {
                    sum = current;
                    result = new String(d);
                }
            }
        }
        out.println(Long.valueOf(result));
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
        try (MaximizeSumOfDigits instance = new MaximizeSumOfDigits()) {
            instance.solve();
        }
    }
}
