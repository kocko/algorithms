package codeforces.contests601_700.problemset623;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class GraphAndString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                size[x] += size[y];
                root[y] = x;
            }
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] graph = new int[n][n];
        int[] d = new int[n];
        while (m-- > 0) {
            int u = in.ni() - 1, v = in.ni() - 1;
            graph[u][v] = graph[v][u] = 1;
            d[u]++;
            d[v]++;
        }
        char[] result = new char[n];
        Arrays.fill(result, '?');
        int p = 0;
        boolean[] set = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (d[i] == n - 1 - p) {
                result[i] = 'b';
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        graph[i][j] = graph[j][i] = 0;
                        d[j]--;
                    }
                }
                d[i] = 0;
                p++;
                set[i] = true;
            }
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    dsu.join(i, j);
                }
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!set[i]) {
                int root = dsu.root(i);
                List<Integer> list = map.getOrDefault(root, new ArrayList<>());
                list.add(i);
                map.put(root, list);
            }
        }
        if (map.size() > 2) {
            out.println("No");
            return;
        }
        char c = 'a';
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            int size = value.size() - 1;
            for (Integer vertex : value) {
                if (d[vertex] != size) {
                    out.println("No");
                    return;
                }
                result[vertex] = c;
            }
            c = 'c';
        }
        out.println("Yes");
        for (char ch : result) {
            out.print(ch);
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
        try (GraphAndString instance = new GraphAndString()) {
            instance.solve();
        }
    }
}
