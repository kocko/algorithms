package codeforces.contests901_1000.problemset961;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LectureSleep implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] a = new int[n], t = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        for (int i = 0; i < n; i++) t[i] = in.ni();
        int[] prefix = new int[n + 1], total = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + a[i - 1];
            total[i] = total[i - 1];
            if (t[i - 1] == 1) {
                total[i] += a[i - 1];
            }
        }
        int result = 0;
        for (int i = k; i <= n; i++) {
            int current = prefix[i] - prefix[i - k];
            int other = total[n] - total[i] + total[i - k];
            if (current + other > result) {
                result = current + other;
            }
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
        try (LectureSleep instance = new LectureSleep()) {
            instance.solve();
        }
    }
}
