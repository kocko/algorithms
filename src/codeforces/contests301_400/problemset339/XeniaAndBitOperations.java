package codeforces.contests301_400.problemset339;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XeniaAndBitOperations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    int n;
    int[] tree;

    private void build() {
        boolean or = true;
        for (int i = n - 1; i > 0; i--) {
            if (or) {
                tree[i] = tree[i << 1] | tree[i << 1 | 1];
            } else {
                tree[i] = tree[i << 1] ^ tree[i << 1 | 1];
            }
            if (((i - 1) & i) == 0) {
                or = !or;
            }
        }
    }

    private void update(int p, int value) {
        boolean or = true;
        for (tree[p += n] = value; p > 1; p >>= 1) {
            if (or) {
                tree[p >> 1] = tree[p] | tree[p ^ 1];
            } else {
                tree[p >> 1] = tree[p] ^ tree[p ^ 1];
            }
            or = !or;
        }
    }

    public void solve() {
        int n = in.ni();
        this.n = 1 << n;
        int m = in.ni(); tree = new int[2 * this.n];
        for (int i = 0; i < this.n; i++) {
            tree[this.n + i] = in.ni();
        }
        build();
        for (int i = 0 ; i < m; i++) {
            update(in.ni() - 1, in.ni());
            out.println(tree[1]);
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

    public static void main(String[] args) {
        new XeniaAndBitOperations().solve();
    }
}
