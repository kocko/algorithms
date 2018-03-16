package codeforces.contests701_800.problemset703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class MishkaAndInterestingSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final int MAX = 1000000;
    
    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
        }
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ x[i];
        }
        int q = in.ni();
        List<Query> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(new Query(i, in.ni(), in.ni()));
        }
        queries.sort(comparingInt(a -> a.right));
        int idx = 0;
        int[] result = new int[q];
        Map<Integer, Integer> lastSeen = new HashMap<>();
        FenwickTree tree = new FenwickTree();
        for (int i = 1; i <= n; i++) {
            if (idx == q) break;

            int value = x[i];
            int seen = lastSeen.getOrDefault(value, -1);
            if (seen != -1) {
                tree.update(seen, value);
            }
            lastSeen.put(value, i);
            tree.update(i, value);
            while (idx < q && queries.get(idx).right == i) {
                Query query = queries.get(idx);
                result[query.idx] = prefix[query.right] ^ prefix[query.left - 1] ^ tree.query(query.left, query.right);
                idx++;
            }
        }
        for (int ans : result) {
            out.println(ans);
        }
    }

    private class Query {
        private int idx, left, right;

        private Query(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }

    private class FenwickTree {
        private int[] tree = new int[MAX + 1];

        public void update(int idx, int delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] ^= delta;
            }
        }
        
        public int query(int left, int right) {
            return query(right) ^ query(left - 1);
        }

        public int query(int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result ^= tree[idx];
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
        try (MishkaAndInterestingSum instance = new MishkaAndInterestingSum()) {
            instance.solve();
        }
    }
}
