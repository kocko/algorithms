package codeforces.contests901_1000.problemset938;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RunForYourPrize implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int me = a[i] - 1, friend = 0;
            if (i < n - 1) {
                friend = 1000000 - a[i + 1];
            }
            min = Math.min(Math.max(me, friend), min);
        }
        min = Math.min(min, 1000000 - a[0]);
        out.println(min);
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
        try (RunForYourPrize instance = new RunForYourPrize()) {
            instance.solve();
        }
    }
}
