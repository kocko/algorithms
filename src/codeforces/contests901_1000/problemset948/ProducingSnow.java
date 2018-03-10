package codeforces.contests901_1000.problemset948;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProducingSnow implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private int MAX;
        private long[] days, tree;
        
        private FenwickTree(long[] arr) {
            MAX = arr.length + 1;
            days = arr;
            tree = new long[MAX + 5];
        }

        private long query(int idx) {
            long res = days[idx], count = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                count += tree[idx];
            }
            return res * count;
        }

        private void update(int idx, long delta) {
            for (; idx <= MAX; idx += (idx & -idx))
                tree[idx] += delta;
        }

        private void update(int left, int right, long delta) {
            update(left, 1L);
            update(right + 1, -1L);
        }
    }

    public void solve() {
        int n = in.ni();
        long[] v = new long[n + 5], t = new long[n + 5], prefix = new long[n + 5], result = new long[n + 5];
        int[] melts = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            v[i] = in.nl();
        }
        for (int i = 1; i <= n; i++) {
            t[i] = in.nl();
            prefix[i] = prefix[i - 1] + t[i];
        }
        FenwickTree tree = new FenwickTree(t);
        for (int i = 1; i <= n; i++) {
            int left = i, right = n;
            int min = n + 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] - prefix[i - 1] >= v[i]) {
                    min = Math.min(min, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            melts[i] = min;
        }
        for (int i = 1; i <= n; i++) {
            int melt = melts[i];
            if (melt == i) {
                result[i] += v[i];
            } else {
                tree.update(i, melt - 1, 1);
                long total = prefix[melt - 1] - prefix[i - 1];
                result[melt] += v[i] - total;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i] + tree.query(i));
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
        try (ProducingSnow instance = new ProducingSnow()) {
            instance.solve();
        }
    }
}
