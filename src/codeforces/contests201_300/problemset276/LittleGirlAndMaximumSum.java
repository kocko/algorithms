package codeforces.contests201_300.problemset276;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LittleGirlAndMaximumSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class FenwickTree {
        private long[] tree;
        private int MAX;

        private FenwickTree(int n) {
            MAX = n;
            tree = new long[MAX + 1];
        }

        public void update(int left, int right, long delta) {
            update(left, delta);
            update(right + 1, -delta);
        }

        private void update(int idx, long delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }

        public long query(int idx) {
            long result = 0L;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni();
        List<Long> values = new ArrayList<>();
        values.add(0L);
        for (int i = 1; i <= n; i++) {
            values.add(in.nl());
        }
        values.sort(Comparator.naturalOrder());
        FenwickTree tree = new FenwickTree(n);
        for (int i = 0; i < q; i++) {
            tree.update(in.ni(), in.ni(), 1);
        }
        List<Long> count = new ArrayList<>();
        count.add(0L);
        for (int i = 1; i <= n; i++) {
            count.add(tree.query(i));
        }
        count.sort(Comparator.naturalOrder());
        long result = 0L;
        for (int i = 1; i <= n; i++) {
            result += count.get(i) * values.get(i);
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
        try (LittleGirlAndMaximumSum instance = new LittleGirlAndMaximumSum()) {
            instance.solve();
        }
    }
}
