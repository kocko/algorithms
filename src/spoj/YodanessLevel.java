package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class YodanessLevel implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            String[] message = new String[n];
            for (int i = 0; i < n; i++) {
                message[i] = in.next();
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(in.next(), i + 1);
            }
            int[] order = new int[n];
            for (int i = 0; i < n; i++) {
                order[i] = map.get(message[i]);
            }
            out.println(inversionCount(order));
        }
    }

    private int inversionCount(int[] order) {
        FenwickTree tree = new FenwickTree();
        int result = 0;
        for (int i = order.length - 1; i >= 0; i--) {
            result += tree.query(order[i]);
            tree.update(order[i]);
        }
        return result;
    }

    private class FenwickTree {
        private final int MAX = 30000;
        private int[] tree = new int[MAX + 1];

        private void update(int idx) {
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx]++;
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
        try (YodanessLevel instance = new YodanessLevel()) {
            instance.solve();
        }
    }
}
