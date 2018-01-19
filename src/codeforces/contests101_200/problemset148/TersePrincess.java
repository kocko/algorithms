package codeforces.contests101_200.problemset148;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TersePrincess implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni();
        if (n == 1) {
            out.println(1);
            return;
        }
        if (b == 0 && a == n - 1) {
            out.println(-1);
            return;
        }
        long[] result = new long[n];
        result[0] = 1;
        int idx = 1;
        long sum = result[0];
        for (int i = 0; i < b; i++) {
            result[idx] = sum + 1;
            sum += result[idx++];
        }
        for (int i = 0; i < a; i++) {
            if (result[idx - 1] + 1 > sum) {
                result[idx] = result[idx - 1];
                a++;
            } else {
                result[idx] = result[idx - 1] + 1;
            }
            sum += result[idx++];
        }
        while (idx < n) {
            result[idx++] = 1;
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (TersePrincess instance = new TersePrincess()) {
            instance.solve();
        }
    }
}
