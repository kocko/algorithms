package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TrueFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            reset(n);
            for (int i = 0; i < n; i++) {
                char[] next = in.next().toCharArray();
                for (int j = 0; j < n; j++) {
                    if (next[j] == 'Y') {
                        graph.get(i).add(j);
                        reverse.get(j).add(i);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) dfs1(i);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                int node = order.get(n - i - 1);
                if (visited[node]) {
                    count++;
                    dfs2(node);
                }
            }
            out.println(count);
        }
    }
    
    private void reset(int n) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        order = new ArrayList<>();
        visited = new boolean[n];
    }

    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private boolean[] visited;
    
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
        try (TrueFriends instance = new TrueFriends()) {
            instance.solve();
        }
    }
}
