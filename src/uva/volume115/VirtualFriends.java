package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class VirtualFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root = new int[200000];
        private int[] size = new int[200000];
        
        private DisjointSet() {
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }
        
        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = (x ^ y) ^ (x = y);
                root[y] = x;
                out.println(size[x] += size[y]);
            } else {
                out.println(size[x]);
            }
        }
    }
    
    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            Map<String, Integer> inv = new HashMap<>();
            int idx = 0;
            DisjointSet dsu = new DisjointSet();
            while (n-- > 0) {
                String x = in.next(), y = in.next();
                int a = inv.getOrDefault(x, idx++);
                inv.putIfAbsent(x, a);
                int b = inv.getOrDefault(y, idx++);
                inv.putIfAbsent(y, b);
                dsu.join(a, b);
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

    public static void main(String[] args) throws IOException {
        try (VirtualFriends instance = new VirtualFriends()) {
            instance.solve();
        }
    }
}
