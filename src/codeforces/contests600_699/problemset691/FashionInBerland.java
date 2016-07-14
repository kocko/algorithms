package codeforces.contests600_699.problemset691;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FashionInBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] buttons = new int[n];
        int zeroes = 0;
        for (int i = 0; i < n; i++) {
            buttons[i] = in.ni();
            if (buttons[i] == 0) zeroes++;
        }
        if (n == 1 && zeroes == 1) {
            out.println("NO");
        } else if (n == 1 && zeroes == 0) {
            out.println("YES");
        } else if (zeroes > 1 || zeroes == 0) {
            out.println("NO");
        } else {
            out.println("YES");
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
        try (FashionInBerland instance = new FashionInBerland()) {
            instance.solve();
        }
    }
}
