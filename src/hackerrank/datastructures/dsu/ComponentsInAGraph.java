package hackerrank.datastructures.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ComponentsInAGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    static class DisjointSet {
        int[] arr;
        int[] size;
        
        public DisjointSet(int n) {
            init(n);
        }

        private void init(int n) {
            this.arr = new int[2 * n + 1];
            for (int i = 1; i <= 2 * n; i++) arr[i] = i;
            this.size = new int[2 * n + 1];
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            while (x != arr[x]) x = arr[x];
            return x;
        }
        
        public void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                arr[y] = x;
                size[x] += size[y];
            }
        }
        
    }

    public void solve() {
        int n = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        while (n-- > 0) {
            int g = in.ni(), b = in.ni();
            dsu.union(g, b);
        }
        int min = (int) 1e5, max = 0;
        for (int i = 1; i < dsu.arr.length; i++) {
            if (i == dsu.arr[i] && dsu.size[i] != 1) {
                max = Math.max(max, dsu.size[i]);
                min = Math.min(min, dsu.size[i]);
            }
        }
        out.println(min + " " + max);
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

    public static void main(String[] args) {
        new ComponentsInAGraph().solve();
    }
}
