package codeforces.contests801_900.problemset816;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KarenAndCoffee implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class FenwickTree {
        private int[] tree;
        private int MAX;

        private FenwickTree(int n) {
            MAX = n;
            tree = new int[MAX + 1];
        }

        public void update(int left, int right, int delta) {
            update(left, delta);
            update(right + 1, -delta);
        }

        private void update(int idx, int delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }

        private int query(int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    public void solve() {
        final int MAX = 200000;
        int n = in.ni(), k = in.ni(), q = in.ni();
        FenwickTree tree = new FenwickTree(MAX);
        for (int i = 0; i < n; i++) {
            tree.update(in.ni(), in.ni(), 1);
        }
        int[] prefix = new int[MAX + 1];
        prefix[0] = 0;
        for (int i = 1; i <= MAX; i++) {
            int query = tree.query(i);
            prefix[i] = prefix[i - 1] + (query >= k ? 1 : 0);
        }
        while (q-- > 0) {
            int left = in.ni(), right = in.ni();
            out.println(prefix[right] - prefix[left - 1]);
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
        try (KarenAndCoffee instance = new KarenAndCoffee()) {
            instance.solve();
        }
    }
}
