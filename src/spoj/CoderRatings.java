package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class CoderRatings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Coder> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Coder(i, in.ni(), in.ni()));
        }
        int[] result = new int[n];
        list.sort(comparingInt(Coder::getOpen).thenComparing(Coder::getHigh));
        FenwickTree tree = new FenwickTree();
        for (int i = 0; i < n; i++) {
            Coder coder = list.get(i);
            if (i > 0) {
                Coder prev = list.get(i - 1);
                if (coder.high == prev.high && coder.open == prev.open) {
                    result[coder.idx] = result[prev.idx];
                } else if (list.get(i - 1).open == coder.open) {
                    int all = tree.query(tree.MAX) - tree.query(coder.high);
                    result[coder.idx] = i - all;
                } else {
                    result[coder.idx] = tree.query(coder.high);
                }
            }
            tree.update(coder.high);
        }
        for (int i : result) {
            out.println(i);
        }
    }
    
    private class FenwickTree {
        private final int MAX = 100000;
        private int[] tree = new int[MAX + 1];
        
        private void update(int idx) {
            for (; idx <= MAX; idx += (idx & -idx)) tree[idx]++;
        }
        
        private int query(int idx) {
            int result = 0;
            for (; idx > 0; idx -= (idx & -idx)) result += tree[idx];
            return result;
        }
    }

    private class Coder {
        private int idx, open, high;

        private Coder(int idx, int open, int high) {
            this.idx = idx;
            this.open = open;
            this.high = high;
        }

        public int getOpen() {
            return open;
        }

        public int getHigh() {
            return high;
        }

        @Override
        public String toString() {
            return open + " " + high;
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
        try (CoderRatings instance = new CoderRatings()) {
            instance.solve();
        }
    }
}
