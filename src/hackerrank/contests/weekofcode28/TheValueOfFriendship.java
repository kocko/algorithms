package hackerrank.contests.weekofcode28;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TheValueOfFriendship implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        private long total;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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
                total += 2L * size[x] * size[y];
                size[x] += size[y];
                root[y] = x;
            } 
        }
    }
    
    private long[] dp = new long[200001];
    private long[] prefix = new long[200001];

    public void solve() {
        for (int i = 1; i <= 200000; i++) {
            dp[i] = i * (i + 1L);
            prefix[i] = dp[i] + prefix[i - 1];
        }
        int q = in.ni();
        while (q-- > 0) {
            int n = in.ni(), m = in.ni();
            final DisjointSet dsu = new DisjointSet(n);
            List<int[]> next = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni();
                if (dsu.root(u) != dsu.root(v)) {
                    dsu.union(u, v);
                } else {
                    next.add(new int[]{u, v});
                }
            }
            long result = 0L;
            List<Integer> sizes = new ArrayList<>(); 
            for (int i = 1; i <= n; i++) {
                int root = dsu.root(i);
                if (dsu.size[root] == 1) continue;
                if (dsu.root(i) == i) sizes.add(dsu.size[root]);
            }
            sizes.sort(Comparator.reverseOrder());
            long additional = 0L;
            for (Integer size : sizes) {
                int s = size - 1;
                result += prefix[s];
                result += additional * s;
                additional += dp[s];
            }
            result += (next.size() * dsu.total);
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
        try (TheValueOfFriendship instance = new TheValueOfFriendship()) {
            instance.solve();
        }
    }
}
