package codeforces.contests101_200.problemset129;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentsAndShoelaces implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int u = in.ni(), v = in.ni();
            graph[u].add(v);
            graph[v].add(u);
        }
        List<Integer> queue = new ArrayList<>();
        int result = -1;
        boolean[] removed = new boolean[n + 1];
        do {
            result++;
            for (Integer x : queue) {
                removed[x] = true;
                for (int i = 1; i <= n; i++) {
                    if (!removed[i])
                        graph[i].remove(x);
                }
            }
            queue.clear();
            for (int i = 1; i <= n; i++) {
                if (!removed[i] && graph[i].size() == 1) {
                    queue.add(i);
                }
            }
        } while (!queue.isEmpty());
        out.println(result);
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
        try (StudentsAndShoelaces instance = new StudentsAndShoelaces()) {
            instance.solve();
        }
    }
}
