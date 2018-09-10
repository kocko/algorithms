package uva.volume012;

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
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class SubDictionary implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = parseInt(in.nextLine())) != 0) {
            reset(n);
            int idx = 0;
            for (int i = 0; i < n; i++) {
                String[] split = in.nextLine().split("\\s+");
                for (int j = 0; j < split.length; j++) {
                    int v;
                    if (!map.containsKey(split[j])) {
                        v = idx;
                        map.put(split[j], v);
                        inv.put(v, split[j]);
                        idx++;
                    } else {
                        v = map.get(split[j]);
                    }
                    if (j > 0) {
                        int u = map.get(split[0]);
                        graph.get(u).add(v);
                        reverse.get(v).add(u);
                        outDegree[u]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs1(i);
                }
            }
            int c = 0;
            visited = new boolean[n];
            for (int i = n - 1; i >= 0; i--) {
                int node = order.get(i);
                if (!visited[node]) {
                    c++;
                    if (outDegree[node] == 0) {
                        component[node] = c;
                        start[node] = true;
                    } else if (dfs2(node, c) > 1) {
                        for (int j = 0; j < n; j++) {
                            if (component[j] == c) {
                                start[j] = true;
                            }
                        }   
                    }
                }
            }
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i] && start[i]) {
                    dfs3(i);
                }
            }
            out.println(result.size());
            StringJoiner joiner = new StringJoiner(" ");
            for (String word : result) {
                joiner.add(word);
            }
            out.println(joiner.toString());
        }
    }
    
    private Map<String, Integer> map;
    private Map<Integer, String> inv;
    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private Set<String> result;
    private boolean[] visited, start;
    private int[] component, outDegree;
    
    private void reset(int n) {
        graph = new ArrayList<>();    
        reverse = new ArrayList<>();
        map = new HashMap<>();
        inv = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        order = new ArrayList<>();
        visited = new boolean[n];
        component = new int[n];
        outDegree = new int[n];
        start = new boolean[n];
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

    private int dfs2(int node, int c) {
        visited[node] = true;
        component[node] = c;
        int result = 1;
        for (int next : reverse.get(node)) {
            if (!visited[next]) {
                result += dfs2(next, c);
            }
        }
        return result;
    }
    
    private void dfs3(int node) {
        visited[node] = true;
        result.add(inv.get(node));
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs3(next);
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
            return parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (SubDictionary instance = new SubDictionary()) {
            instance.solve();
        }
    }
}
