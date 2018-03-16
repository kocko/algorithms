package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class RoundRobinScheduling implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n], sorted = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            sorted[i] = x[i];
        }
        sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        map.putIfAbsent(sorted[0], 1);
        for (int i = 1; i < n; i++) {
            if (sorted[i] > sorted[i - 1]) {
                map.put(sorted[i], ++rank);
            }
        }
        long[] left = new long[n];
        FenwickTree leftSum = new FenwickTree(rank), leftCount = new FenwickTree(rank);
        leftSum.update(map.get(x[0]), x[0]);
        leftCount.update(map.get(x[0]), 1);
        for (int i = 1; i < n; i++) {
            int value = x[i], r = map.get(x[i]);
            long lowRankSum = leftSum.query(r - 1);
            long biggerRankCount = leftCount.query(rank) - leftCount.query(r - 1);
            leftSum.update(map.get(x[i]), x[i]);
            leftCount.update(map.get(x[i]), 1);
            left[i] = lowRankSum + biggerRankCount * value;
        }

        long[] right = new long[n];
        FenwickTree rightSum = new FenwickTree(rank), rightCount = new FenwickTree(rank);
        rightSum.update(map.get(x[n - 1]), x[n - 1]);
        rightCount.update(map.get(x[n - 1]), 1);
        for (int i = n - 2; i >= 0; i--) {
            int value = x[i], r = map.get(x[i]);
            long lowRankSum = rightSum.query(r - 1);
            long biggerRankCount = rightCount.query(rank) - rightCount.query(r - 1);
            rightSum.update(map.get(x[i]), x[i]);
            rightCount.update(map.get(x[i]), 1);
            right[i] = lowRankSum + biggerRankCount * (value - 1);
        }

        for (int i = 0; i < n; i++) {
            out.print(x[i] + left[i] + right[i]);
            out.print(' ');
        }
    }

    private class FenwickTree {
        private int MAX;
        private long[] tree;

        private FenwickTree(int n) {
            MAX = n;
            tree = new long[MAX + 1];
        }

        private void update(int idx, long delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }
        
        private long query(int idx) {
            long result = 0L;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
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
        try (RoundRobinScheduling instance = new RoundRobinScheduling()) {
            instance.solve();
        }
    }
}
