package codeforces.contests301_400.problemset302;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EugenyAndArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni(), plus = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            if (a[i] == 1) plus++;
        }
        int minus = n - plus;
        while (q-- > 0) {
            int left = in.ni() - 1, right = in.ni() - 1, size = right - left + 1;
            boolean ok = size % 2 == 0;
            ok &= (size / 2) <= plus;
            ok &= (size / 2) <= minus;
            out.println(ok ? "1" : "0");
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
        try (EugenyAndArray instance = new EugenyAndArray()) {
            instance.solve();
        }
    }
}
