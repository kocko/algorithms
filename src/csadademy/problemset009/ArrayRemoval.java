package csadademy.problemset009;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Long.max;

public class ArrayRemoval implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    class DisjointSet {
        int[] root;
        long[] scores;
        long maximal = 0;
        
        public DisjointSet(int n, long[] scores) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            this.scores = scores;
        }
        
        public int root(int x) {
            return (root[x] == x) ? x : (root[x] = root(root[x]));
        }
        
        public void union(int x, int y) {
            int rootX = root(x), rootY = root(y);
            root[rootY] = rootX;
            scores[rootX] += scores[rootY];
            maximal = max(scores[rootX], maximal);
        }
        
        long getMaximalScore() {
            return maximal; 
        }
    }
    
    public void solve() {
        int n = in.ni();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = in.ni();
        }
        boolean[] used = new boolean[n];
        DisjointSet dsu = new DisjointSet(n, x);
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            int next = order[n - i - 1] - 1;
            boolean joined = false;
            if (next - 1 >= 0) {
                if (used[next - 1]) {
                    joined = true;
                    dsu.union(next, next - 1);
                }
            }
            if (next + 1 < n) {
                if (used[next + 1]) {
                    joined = true;
                    dsu.union(next + 1, next);
                }
            }
            if (!joined) {
                dsu.maximal = Math.max(dsu.maximal, x[next]);
            }
            used[next] = true;
            result[n - i - 1] = dsu.getMaximalScore();
        }
        Arrays.stream(result).forEach(out::println);
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
        try (ArrayRemoval instance = new ArrayRemoval()) {
            instance.solve();
        }
    }
}
