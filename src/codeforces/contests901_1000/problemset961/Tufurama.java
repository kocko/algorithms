package codeforces.contests901_1000.problemset961;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Tufurama implements Closeable {

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
            for (; idx <= MAX; idx += (idx & -idx)) {
                tree[idx]++;
            }
        }
        
        private long query(int idx) {
            long result = 0;
            for (; idx > 0; idx -= (idx & -idx)) {
                result += tree[idx];
            }
            return result;
        }
    }

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
            list.get(min(x[i], n)).add(i);
        }
        FenwickTree tree = new FenwickTree(n);
        long result = 0;
        for (int i = n; i > 0; i--) {
            for (int v : list.get(i)) {
                tree.update(v);
            }
            result += tree.query(min(i - 1, x[i]));
        }
        out.println(result);
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
        try (Tufurama instance = new Tufurama()) {
            instance.solve();
        }
    }
}
