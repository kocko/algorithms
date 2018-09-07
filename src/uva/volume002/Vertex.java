package uva.volume002;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Vertex implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            while (true) {
                int u = in.ni();
                if (u == 0) break;
                while (true) {
                    int v = in.ni();
                    if (v == 0) break;
                    graph.get(u).add(v);
                }
            }
            int q = in.ni();
            while (q-- > 0) {
                visited = new boolean[n + 1];
                int start = in.ni();
                dfs(start);
                List<Integer> result = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    if (!visited[i]) {
                        result.add(i);
                    }
                }
                print(result);
            }
        }
    }
    
    private List<List<Integer>> graph;
    private boolean[] visited;
    
    private void dfs(int node) {
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
    
    private void print(List<? extends Integer> list) {
        out.print(list.size());
        if (list.size() > 0) {
            out.print(' ');
        }
        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i));
            if (i < list.size() - 1) {
                out.print(' ');
            }
        }
        out.println();
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
        try (Vertex instance = new Vertex()) {
            instance.solve();
        }
    }
}
