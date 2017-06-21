package hackerrank.contests.weekofcode33;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TransformToPalindrome implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
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
                size[x] += y;
            }
        }
    }

    public void solve() {
        int n = in.ni(), k = in.ni(), m = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < k; i++) {
            dsu.union(in.ni(), in.ni());
        }
        x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = dsu.root(in.ni());
        }
        dp = new int[m][m];
        recurse(0, m - 1);
        out.println(dp[0][m - 1]);
    }

    private int[][] dp;
    private int[] x;

    private int recurse(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        if (i > j) return 0;
        else if (i == j) return 1;

        int ans;
        if (x[i] == x[j]) {
            ans = 2 + recurse(i + 1, j - 1);
        } else {
            ans = Math.max(recurse(i + 1, j), recurse(i, j - 1));
        }
        return (dp[i][j] = ans);
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
        try (TransformToPalindrome instance = new TransformToPalindrome()) {
            instance.solve();
        }
    }
}
