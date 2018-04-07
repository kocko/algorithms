package codeforces.contests901_1000.problemset960;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class MinimizeTheError implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni() + in.ni();
        long[] a = new long[n], b = new long[n], diff = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nl();
        for (int i = 0; i < n; i++) b[i] = in.nl();
        for (int i = 0; i < n; i++) diff[i] = abs(a[i] - b[i]);
        sort(diff);
        while (k-- > 0) {
            if (diff[n - 1] > 0) diff[n - 1]--;
            else diff[n - 1]++;
            sort(diff);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += diff[i] * diff[i];
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
        try (MinimizeTheError instance = new MinimizeTheError()) {
            instance.solve();
        }
    }
}
