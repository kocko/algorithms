package codeforces.contests001_100.problemset025;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RoadsNotOnlyInBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root, size;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    y = x ^ y ^ (x = y);
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
    }

    public void solve() {
        int n = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        ArrayDeque<int[]> edgesToDelete = new ArrayDeque<>();
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            int ru = dsu.root(u), rv = dsu.root(v);
            if (ru == rv) {
                edgesToDelete.add(new int[]{u, v});
            } else {
                dsu.union(u, v);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ru = dsu.root(i), rv = dsu.root(j);
                if (ru != rv) {
                    int[] del = edgesToDelete.pollFirst();
                    result.add(String.format("%d %d %d %d", del[0] + 1, del[1] + 1, ru + 1, rv + 1));
                    dsu.union(ru, rv);
                }
            }
        }
        out.println(result.size());
        result.forEach(out::println);
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
        try (RoadsNotOnlyInBerland instance = new RoadsNotOnlyInBerland()) {
            instance.solve();
        }
    }
}
