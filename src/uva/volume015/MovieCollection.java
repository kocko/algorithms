package uva.volume015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MovieCollection implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class FenwickTree {
        private int MAX;
        private int[] tree;

        private FenwickTree(int n) {
            MAX = n + 1;
            tree = new int[MAX + 1];
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
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), q = in.ni(), max = n + q;
            FenwickTree tree = new FenwickTree(max);
            int[] index = new int[n + 1];
            int[] init = new int[2 * max + 1];
            for (int i = 1; i <= n; i++) {
                index[i] = n - i + 1;
                init[i] = n - i;
            }
            int top = n + 1;
            while (q-- > 0) {
                int next = in.ni(), place = index[next];
                out.print(init[place] + tree.query(place));
                if (q > 0) out.print(' ');
                tree.update(place + 1, 1);
                tree.update(top, -1);
                index[next] = top++;
            }
            out.println();
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
        try (MovieCollection instance = new MovieCollection()) {
            instance.solve();
        }
    }
}
