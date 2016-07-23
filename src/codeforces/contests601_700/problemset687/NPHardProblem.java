package codeforces.contests601_700.problemset687;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class NPHardProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private List<Integer>[] adj;
    private int[] color;
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = in.ni() - 1, y = in.ni() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            if (!dfs(i, 1)) {
                out.println(-1);
                return;
            }
        }
        
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = color[i] == 1 ? first : second;
            list.add(i + 1);
        }
        printSet(first);
        printSet(second);
    }

    private boolean dfs(int x, int flag) {
        if (color[x] != 0) {
            return color[x] == flag;
        }
        color[x] = flag;
        for (int y : adj[x]) {
            if (!dfs(y, -flag)) {
                return false;
            }
        }
        return true;
    }
    
    private void printSet(Collection<Integer> c) {
        out.println(c.size());
        c.stream().forEach(x -> out.print(x + " "));
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
        try (NPHardProblem instance = new NPHardProblem()) {
            instance.solve();
        }
    }
}
