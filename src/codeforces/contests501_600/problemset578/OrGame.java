package codeforces.contests501_600.problemset578;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OrGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long k = in.nl(), x = in.nl();
        long value = 1L;
        while (k-- > 0) value *= x;
        long[] a = new long[n + 2];
        long[] prefix = new long[n + 2], suffix = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nl();
            prefix[i] = prefix[i - 1] | a[i];
        }
        for (int i = n; i >= 1; i--) {
            suffix[i] = suffix[i + 1] | a[i];
        }
        long result = 0L;
        for (int i = 1; i <= n; i++) {
            long temp = a[i] * value;
            temp |= (prefix[i - 1] | suffix[i + 1]);
            if (temp > result) result = temp;
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
        try (OrGame instance = new OrGame()) {
            instance.solve();
        }
    }
}
