package codeforces.contests401_500.problemset500;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NewYearPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                root[i] = i;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
        
    }

    public void solve() {
        int n = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
        }
        for (int i = 1; i <= n; i++) {
            char[] c = in.next().toCharArray();
            for (int j = 1; j <= n; j++) {
                if (c[j - 1] == '1') {
                    dsu.union(i, j);
                }
            }
        }
        boolean[] processed = new boolean[n + 1];
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dsu.root(i) == i) {
                if (!processed[i]) {
                    List<Integer> values = new ArrayList<>();
                    List<Integer> indices = new ArrayList<>();
                    for (int j = 1; j <= n; j++) {
                        if (dsu.root(j) == i) {
                            values.add(x[j]);
                            indices.add(j);
                        }
                    }
                    Collections.sort(values);
                    int next = 0;
                    for (Integer value : values) {
                        result[indices.get(next++)] = value;
                    }
                }
                processed[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i + 1] + " ");
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
        try (NewYearPermutation instance = new NewYearPermutation()) {
            instance.solve();
        }
    }
}
