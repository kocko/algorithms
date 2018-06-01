package codeforces.contests901_1000.problemset985;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.sort;

public class ChessPlacing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            x[i] = in.ni();
        }
        sort(x);
        int a = 0, b = 0, idx = 0;
        for (int i = 1; i <= n; i += 2, idx++) {
            a += abs(i - x[idx]);
        }
        idx = 0;
        for (int i = 2; i <= n; i += 2, idx++) {
            b += abs(i - x[idx]);
        }
        out.println(min(a, b));
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
        try (ChessPlacing instance = new ChessPlacing()) {
            instance.solve();
        }
    }
}
