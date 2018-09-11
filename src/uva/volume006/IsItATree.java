package uva.volume006;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IsItATree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int u, v, testCase = 1;
        while (true) {
            u = in.ni();
            v = in.ni();
            if (u < 0 && v < 0) break;
            parent = new HashMap<>();
            graph = new HashMap<>();
            visited = new TreeSet<>();
            boolean ok = true;
            int edges = 0;
            while (true) {
                if (u == 0 && v == 0) break;
                edges++;
                List<Integer> list = graph.getOrDefault(u, new ArrayList<>());
                list.add(v);
                graph.put(u, list);
                if (!parent.containsKey(v)) {
                    parent.put(v, u);
                } else {
                    ok = false;
                }
                u = in.ni();
                v = in.ni();
            }
            if (graph.size() > 0) {

                int root = -1;
                for (int key : graph.keySet()) {
                    if (parent.get(key) == null) {
                        if (root == -1) {
                            root = key;
                        } else {
                            ok = false;
                            break;
                        }
                    }
                }
                if (root != -1) {
                    dfs(root);
                    ok &= visited.size() == edges + 1;
                } else {
                    ok = false;
                }
            }
            if (ok) {
                out.printf("Case %d is a tree.\n", testCase);
            } else {
                out.printf("Case %d is not a tree.\n", testCase);
            }
            testCase++;
        }
    }

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> parent;
    private Set<Integer> visited;
    
    private void dfs(int node) {
        visited.add(node);
        List<Integer> list = graph.getOrDefault(node, new ArrayList<>());
        for (int next : list) {
            if (!visited.contains(next)) {
                dfs(next);
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
        try (IsItATree instance = new IsItATree()) {
            instance.solve();
        }
    }
}
