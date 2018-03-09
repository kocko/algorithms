package codeforces.contests501_600.problemset586;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LaurentyAndShop implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n - 1], b = new int[n - 1], c = new int[n];
        for (int i = 0; i <= n - 2; i++) a[i] = in.ni();
        for (int i = 0; i <= n - 2; i++) b[i] = in.ni();
        for (int i = 0; i <= n - 1; i++) c[i] = in.ni();
        int[] forward = new int[n - 1], backward = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) forward[i] = a[i];
            else forward[i] = forward[i - 1] + a[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            if (i == n - 2) backward[i] = b[i];
            else backward[i] = backward[i + 1] + b[i];
        }
        int[] cross = new int[n];
        for (int i = 0; i < n; i++) {
            cross[i] = c[i];
            if (i == 0) {
                cross[i] += backward[i];
            } else if (i == n - 1) {
                cross[i] += forward[i - 1];
            } else {
                cross[i] += forward[i - 1] + backward[i];
            }
        }
        Arrays.sort(cross);
        out.println(cross[0] + cross[1]);
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
        try (LaurentyAndShop instance = new LaurentyAndShop()) {
            instance.solve();
        }
    }
}
