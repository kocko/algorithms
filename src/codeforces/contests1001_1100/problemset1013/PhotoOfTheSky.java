package codeforces.contests1001_1100.problemset1013;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Comparator.naturalOrder;

public class PhotoOfTheSky implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(0);
            return;
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n + n; i++) {
            list.add(in.nl());
        }
        list.sort(naturalOrder());
        long result = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            long x = list.get(i + n - 1) - list.get(i);
            long y;
            if (i == 0) {
                y = list.get(2 * n - 1) - list.get(i + 1);
            } else if (i == n) {
                y = list.get(n - 1) - list.get(0);
            } else {
                y = list.get(2 * n - 1) - list.get(0);
            }
            result = min(result, x * y);
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
        try (PhotoOfTheSky instance = new PhotoOfTheSky()) {
            instance.solve();
        }
    }
}
