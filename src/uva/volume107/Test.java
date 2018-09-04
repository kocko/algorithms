package uva.volume107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.String.valueOf;

public class Test implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, cases = 0;
        while ((n = in.ni()) != 0) {
            reset();
            if (cases >= 1) out.println();
            for (int i = 0; i < n; i++) {
                int[] v = new int[6];
                for (int j = 0; j < 6; j++) {
                    v[j] = in.next().charAt(0) - 'A';
                }
                for (int j = 0; j < 6; j++) {
                    if (graph.get(v[j]) == null) {
                        graph.set(v[j], new ArrayList<>());
                        reverse.set(v[j], new ArrayList<>());
                    }
                }
                for (int j = 0; j < 5; j++) {
                    if (v[j] != v[5]) {
                        graph.get(v[5]).add(v[j]);
                        reverse.get(v[j]).add(v[5]);
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (graph.get(i) != null && !visited[i]) {
                    dfs1(i);
                }
            }
            for (int i = 0; i < order.size(); i++) {
                int node = order.get(order.size() - i - 1);
                if (visited[node]) {
                    component = new TreeSet<>();
                    dfs2(node);
                }
                StringJoiner entry = new StringJoiner(" ");
                for (String vertex : component) entry.add(vertex);
                result.add(entry.toString());
            }
            result.forEach(out::println);
            cases++;
        }
    }

    private List<List<Integer>> graph, reverse;
    private Set<String> result;
    private Set<String> component;
    private List<Integer> order;
    private boolean[] visited;

    private void reset() {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(null);
            reverse.add(null);
        }
        visited = new boolean[26];
        result = new TreeSet<>();
    }

    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        order.add(node);
    }

    private void dfs2(int node) {
        visited[node] = false;
        component.add(valueOf((char) ('A' + node)));
        for (int next : reverse.get(node)) {
            if (visited[next]) {
                dfs2(next);
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
        try (Test instance = new Test()) {
            instance.solve();
        }
    }
}
