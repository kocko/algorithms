package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        private boolean[] isTree;
        
        private DisjointSet(String[] nodes) {
            root = new int[26];
            size = new int[26];
            isTree = new boolean[26];
            for (String node : nodes) {
                int idx = node.charAt(0) - 'A';
                root[idx] = idx;
                size[idx] = 1;
                isTree[idx] = true;
            }
        }
        
        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }
        
        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    y = (x ^ y) ^ (x = y); 
                }
                root[y] = x;
                size[x] += size[y];
            } else {
                isTree[x] = false;
            }
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            List<String> edges = new ArrayList<>();
            String line;
            while (!(line = in.next()).startsWith("*")) {
                edges.add(line);
            }
            String nodes = in.next();
            DisjointSet dsu = new DisjointSet(nodes.split(","));
            for (String edge : edges) {
                dsu.join(edge.charAt(1) - 'A', edge.charAt(3) - 'A');
            }
            int trees = 0, almonds = 0;
            for (int i = 0; i < 26; i++) {
                if (dsu.root(i) == i && dsu.isTree[i]) {
                    if (dsu.size[i] == 1) almonds++;
                    else trees++;
                }
            }
            out.printf("There are %d tree(s) and %d acorn(s).\n", trees, almonds);
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
