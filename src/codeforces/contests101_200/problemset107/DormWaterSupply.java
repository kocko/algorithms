package codeforces.contests101_200.problemset107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DormWaterSupply implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), p = in.ni();
        if (p == 0) {
            out.println(0);
            return;
        }
        int[] next = new int[n];
        int[] capacity = new int[n];
        boolean[] incoming = new boolean[n], outgoing = new boolean[n];
        for (int i = 0; i < p; i++) {
            int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
            next[u] = v;
            capacity[u] = w;
            outgoing[u] = true;
            incoming[v] = true;
        }
        List<int[]> result = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            if (!incoming[u] && !outgoing[u]) continue;
            if (!incoming[u]) {
                int current = u, min = (int) 1e7;
                while (outgoing[current]) {
                    int v = next[current];
                    min = Math.min(capacity[current], min);
                    current = v;
                }
                result.add(new int[]{u + 1, current + 1, min});
            }
        }
        out.println(result.size());
        for (int[] triple : result) {
            out.println(triple[0] + " " + triple[1] + " " + triple[2]);
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
        try (DormWaterSupply instance = new DormWaterSupply()) {
            instance.solve();
        }
    }
}
