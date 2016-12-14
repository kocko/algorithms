package codeforces.contests201_300.problemset217;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class IceSkating implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i < n; i++) {
                root[i + 1] = i + 1;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        public int root(int x) {
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
    
    private class Point {
        int x;
        int y;
        int index;
        
        private Point(int index, int x, int y) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
    
    public void solve() {
        int n = in.ni();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Point(i + 1, in.ni(), in.ni()));
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            Point a = list.get(i);
            for (int j = i + 1; j < n; j++) {
                Point b = list.get(j);
                if (a.x == b.x) {
                    dsu.union(i + 1, j + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Point a = list.get(i);
            for (int j = i + 1; j < n; j++) {
                Point b = list.get(j);
                if (a.y == b.y) {
                    dsu.union(i + 1, j + 1);
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i == dsu.root(i)) cnt++;
        }
        out.println(cnt - 1);
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
        try (IceSkating instance = new IceSkating()) {
            instance.solve();
        }
    }
}
