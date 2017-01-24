package codeforces.contests701_800.problemset731;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Socks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        public int root(int x) {
            return x == root[x] ? root[x] : (root[x] = root(root[x]));
        }
        
        private void union(int a, int b) {
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
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] socks = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            socks[i] = in.ni();
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < m; i++) {
            int left = in.ni(), right = in.ni();
            dsu.union(left, right);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = dsu.root(i);
            if (dsu.size[root] > 1) {
                List<Integer> list = map.getOrDefault(root, new ArrayList<>());
                list.add(socks[i]);
                map.put(root, list);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            Collections.sort(value);
            int length = 0, current = 1;
            for (int i = 1; i < value.size(); i++) {
                if (value.get(i).equals(value.get(i - 1))) {
                    current++;
                } else {
                    length = Math.max(length, current);
                    current = 1;
                }
            }
            length = Math.max(length, current);
            result += value.size() - length;
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
        try (Socks instance = new Socks()) {
            instance.solve();
        }
    }
}
