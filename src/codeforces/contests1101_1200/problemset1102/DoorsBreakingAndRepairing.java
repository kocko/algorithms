package codeforces.contests1101_1200.problemset1102;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DoorsBreakingAndRepairing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni(), y = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        if (x > y) {
            out.println(n);
        } else {
            int less = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] <= x) less++;
            }
            less += (less % 2);
            out.println(less / 2);
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
        try (DoorsBreakingAndRepairing instance = new DoorsBreakingAndRepairing()) {
            instance.solve();
        }
    }
}
