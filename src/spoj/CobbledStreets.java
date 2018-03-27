package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingLong;

public class CobbledStreets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            go();
        }
    }

    private void go() {
        long price = in.nl();
        int n = in.ni(), m = in.ni();
        PriorityQueue<Street> queue = new PriorityQueue<>(comparingLong(Street::getTotal));
        for (int i = 0; i < m; i++) {
            Street street = new Street(in.ni(), in.ni(), in.nl());
            queue.offer(street);
        }
        DisjointSet dsu = new DisjointSet(n);
        long total = 0;
        while (!queue.isEmpty()) {
            Street top = queue.poll();
            if (dsu.join(top.u, top.v)) total += top.total;
        }
        out.println(total * price);
    }
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }
        
        private boolean join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = x ^ y ^ (x = y);
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
        }
    }
    
    private class Street {
        private int u, v;
        private long total;

        private Street(int u, int v, long total) {
            this.u = u;
            this.v = v;
            this.total = total;
        }

        public long getTotal() {
            return total;
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
        try (CobbledStreets instance = new CobbledStreets()) {
            instance.solve();
        }
    }
}
