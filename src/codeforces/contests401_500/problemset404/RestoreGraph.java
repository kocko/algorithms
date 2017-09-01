package codeforces.contests401_500.problemset404;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class RestoreGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            list.get(next).add(i);
            max = Math.max(next, max);
        }
        if (list.get(0).size() != 1) {
            out.println(-1);
            return;
        }
        List<int[]> result = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 1; i <= max; i++) {
            List<Integer> previous = list.get(i - 1);
            List<Integer> current = list.get(i);
            int idx = 0, size = previous.size();
            if (previous.size() == 0) {
                out.println(~0);
                return;
            }
            for (Integer u : current) {
                int v = previous.get(idx);
                result.add(new int[]{u, v});
                degree[u]++;
                degree[v]++;
                if (degree[u] > k || degree[v] > k) {
                    out.println(-1);
                    return;
                }
                idx = (idx + 1) % size;
            }
        }
        out.println(result.size());
        for (int[] edge : result) {
            out.println((edge[0] + 1) + " " + (edge[1] + 1));
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
        try (RestoreGraph instance = new RestoreGraph()) {
            instance.solve();
        }
    }
}
