package uva.volume002;

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
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CallingCircles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 1;
        while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
            reset();
            if (testCase > 1) out.println();
            while (m-- > 0) {
                String x = in.next(), y = in.next();
                int u = getIdx(x), v = getIdx(y);
                idxToName.put(u, x);
                idxToName.put(v, y);
                graph[u] |= (1 << v);
                reverse[v] |= (1 << u);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs1(i);
                }
            }
            out.printf("Calling circles for data set %d:\n", testCase++);
            for (int i = 0; i < n; i++) {
                int node = order.get(n - i - 1);
                if (visited[node]) {
                    component = new StringJoiner(", ");
                    dfs2(node);
                    out.println(component.toString());
                }
            }
        }
    }
    
    private int n, m;
    private Map<String, Integer> nameToIdx = new HashMap<>();
    private Map<Integer, String> idxToName = new HashMap<>();
    private int[] graph, reverse;
    private boolean[] visited;
    private List<Integer> order;
    private StringJoiner component;

    private void reset() {
        nameToIdx = new HashMap<>();
        idxToName = new HashMap<>();
        graph = new int[n];
        reverse = new int[n];
        visited = new boolean[n];
        order = new ArrayList<>();
    }

    private int getIdx(String name) {
        int idx;
        if (nameToIdx.containsKey(name)) {
            idx = nameToIdx.get(name);
        } else {
            idx = nameToIdx.size();
            nameToIdx.put(name, idx);
        }
        return idx;
    }
    
    private void dfs1(int node) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (graph[node] & (1 << i)) != 0) {
                dfs1(i);
            }
        }
        order.add(node);
    }
    
    private void dfs2(int node) {
        visited[node] = false;
        component.add(idxToName.get(node));
        for (int i = 0; i < n; i++) {
            if (visited[i] && (reverse[node] & (1 << i)) != 0) {
                dfs2(i);
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
        try (CallingCircles instance = new CallingCircles()) {
            instance.solve();
        }
    }
}
