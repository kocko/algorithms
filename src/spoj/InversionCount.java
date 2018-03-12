package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InversionCount implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class FenwickTree {
        private int MAX;
        private long[] tree;

        private FenwickTree(int n) {
            MAX = n;
            tree = new long[MAX + 1];
        }

        private void update(int idx) {
            while (idx > 0) {
                tree[idx]++;
                idx -= (idx & -idx);
            }
        }

        private long query(int idx) {
            long result = 0;
            while (idx <= MAX) {
                result += tree[idx];
                idx += (idx & -idx);
            }
            return result;
        }
    }


    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            long result = 0L;
            FenwickTree tree = new FenwickTree(10000000);
            for (int i = 0; i < n; i++) {
                int next = in.ni();
                result += tree.query(next);
                tree.update(next);
            }
            out.println(result);
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
        try (InversionCount instance = new InversionCount()) {
            instance.solve();
        }
    }
}
