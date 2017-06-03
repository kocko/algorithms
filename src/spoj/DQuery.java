package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DQuery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class FenwickTree {
        private int[] tree;
        private int MAX;

        private FenwickTree(int n) {
            MAX = n;
            tree = new int[MAX + 1];
        }

        private void update(int idx, int delta) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx] += delta;
            }
        }

        private int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        private int query(int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    private class Query implements Comparable<Query> {
        private int idx, left, right;

        private Query(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Query query) {
            return Integer.compare(this.right, query.right);
        }
    }

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
        }
        int q = in.ni();
        List<Query> queries = new ArrayList<>();
        for (int j = 0; j < q; j++) {
            int left = in.ni(), right = in.ni();
            queries.add(new Query(j, left, right));
        }
        int[] lastSeen = new int[1000001];
        Collections.sort(queries);
        FenwickTree tree = new FenwickTree(n);
        int idx = 0;
        int[] result = new int[q];
        for (int i = 1; i <= n; i++) {
            if (idx == queries.size()) break;
            
            int value = x[i];
            if (lastSeen[value] != 0) {
                tree.update(lastSeen[value], -1);
            }
            lastSeen[value] = i;
            tree.update(i, 1);
            while (idx < queries.size() && queries.get(idx).right == i) {
                Query query = queries.get(idx);
                result[query.idx] = tree.query(query.left, query.right);
                idx++;
            }
        }
        for (int i = 0; i < q; i++) {
            out.println(result[i]);
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
        try (DQuery instance = new DQuery()) {
            instance.solve();
        }
    }
}
