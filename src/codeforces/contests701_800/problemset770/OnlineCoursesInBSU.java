package codeforces.contests701_800.problemset770;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OnlineCoursesInBSU implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] need = new int[k];
        for (int i = 0; i < k; i++) {
            need[i] = in.ni() - 1;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            int count = in.ni();
            for (int j = 0; j < count; j++) {
                int v = in.ni() - 1;
                graph.get(u).add(v);
            }
        }
        color = new int[n];
        for (int node : need) {
            dfs(node);
        }
        if (ok) {
            out.println(result.size());
            for (int i : result) {
                out.print(i + 1);
                out.print(' ');
            }
        } else {
            out.println(-1);
        }
    }

    private boolean ok = true;
    private int[] color;
    private List<Integer> result = new ArrayList<>();
    private List<List<Integer>> graph = new ArrayList<>();
    
    private void dfs(int u) {
        if (color[u] == 0) {
            color[u] = 1;
            for (int v : graph.get(u)) dfs(v);
            result.add(u);
            color[u] = 2;
        } else if (color[u] == 1) {
            ok = false;
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
        try (OnlineCoursesInBSU instance = new OnlineCoursesInBSU()) {
            instance.solve();
        }
    }
}
