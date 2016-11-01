package hackerrank.datastructures.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ZombieCluster implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    static class DisjointSet {
        int[] root;
        int[] size;

        public DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 1; i <= n; i++) root[i] = i;
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        public void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                size[x] += size[y];
                root[y] = x;
            }
        }
    }
    
    public void solve() {
        int n = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 1; i <= n; i++) {
            char[] next = in.next().toCharArray();
            for (int j = i + 1; j <= next.length; j++) {
                if (next[j - 1] == '1') {
                    dsu.union(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dsu.root(i) == i) {
                result++;
            }
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
        try (ZombieCluster instance = new ZombieCluster()) {
            instance.solve();
        }
    }
}
