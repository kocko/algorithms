package codeforces.contests801_900.problemset884;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BertownSubway implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = in.ni();
        visited = new boolean[n + 1];
        List<Long> sizes = new ArrayList<>();
        long total = 0L;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                long size = dfs(i);
                sizes.add(size);
                total += size * size;
            }
        }
        if (sizes.size() >= 2) {
            sizes.sort(Comparator.reverseOrder());
            long first = sizes.get(0), second = sizes.get(1), join = first + second;
            out.println(total - first * first - second * second + join * join);
        } else {
            out.println(total);
        }
    }
    
    private int[] p;
    private boolean[] visited;
    
    private long dfs(int root) {
        visited[root] = true;
        if (!visited[p[root]]) {
            return 1L + dfs(p[root]);
        }
        return 1L;
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
        try (BertownSubway instance = new BertownSubway()) {
            instance.solve();
        }
    }
}
