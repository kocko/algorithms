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

public class MergingCommunities implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    static class DisjointSet {
        int[] arr;
        int[] size;
        
        public DisjointSet(int n) {
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) arr[i] = i;
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        public int find(int x) {
            while (x != arr[x]) x = arr[x];
            return x;
        }
        
        public void union(int a, int b) {
            int x = find(a), y = find(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                size[x] += size[y];
                arr[y] = x;
            }
        }
    }
    public void solve() {
        int n = in.ni(), q = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        while (q-- > 0) {
            String type = in.next();
            if ("Q".equals(type)) {
                int element = in.ni();
                int root = dsu.find(element);
                out.println(dsu.size[root]);
            } else if ("M".equals(type)) {
                dsu.union(in.ni(), in.ni());
            }
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

    public static void main(String[] args) {
        new MergingCommunities().solve();
    }
}
