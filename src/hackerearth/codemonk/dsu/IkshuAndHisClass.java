package hackerearth.codemonk.dsu;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IkshuAndHisClass implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    class DisjointSet {
        int[] root;
        int[] size;
        
        DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        int root(int x) {
            return (root[x] == x) ? x : (root[x] = root(root[x]));
        }
        
        void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                int sizeX = size[x], sizeY = size[y];
                if (sizeX < sizeY) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
        
    }

    private final int MOD = (int) 1e9 + 7;
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        DisjointSet dsu = new DisjointSet(n);
        while (k-- > 0) {
            dsu.union(in.ni(), in.ni());
        }
        long result = 1;
        for (int i = 0; i < n; i++) {
            if (dsu.root(i) == i) {
                int size = dsu.size[i];
                if (size > 1) {
                    result = (result * fact(size)) % MOD;
                }
            }
        }
        out.println(result);
    }
    
    private long fact(long n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
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
        try (IkshuAndHisClass instance = new IkshuAndHisClass()) {
            instance.solve();
        }
    }
}
