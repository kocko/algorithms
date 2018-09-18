package codeforces.contests1001_1100.problemset1036;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class VasyaAndArrays implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        int m = in.ni();
        long[] y = new long[m];
        for (int i = 0; i < m; i++) {
            y[i] = in.nl();
        }
        int a = 1, b = 1, cnt = 0;
        long first = x[0], second = y[0];
        while (a < n && b < m) {
            if (first == second) {
                cnt++;
                first = x[a++];
                second = y[b++];
            } else if (first < second) {
                first += x[a++];
            } else {
                second += y[b++];
            }
        }
        while (a < n) first += x[a++];
        while (b < m) second += y[b++];
        if (first == second) {
            out.println(cnt + 1);
        } else {
            out.println(-1);
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
        try (VasyaAndArrays instance = new VasyaAndArrays()) {
            instance.solve();
        }
    }
}
