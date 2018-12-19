package codeforces.contests1001_1100.problemset1043;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MysteriousCrime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = in.ni();
            }
        }
        int[] next = new int[n + 1];

        for (int i = 1; i < n; i++) {
            next[data[0][i - 1]] = data[0][i];
        }
        for (int neighbour = 1; neighbour < m; neighbour++) {
            for (int i = 0; i < n - 1; i++) {
                if (next[data[neighbour][i]] != data[neighbour][i + 1]) {
                    next[data[neighbour][i]] = 0;
                }
            }
            next[data[neighbour][n - 1]] = 0;
        }
        boolean[] mark = new boolean[n + 1];

        long result = 0;
        for (int i = 0; i < n; i++) {
            int start = data[0][i];
            if (!mark[start]) {
                int current = start, chain = 0;
                while (current != 0) {
                    mark[current] = true;
                    current = next[current];
                    chain++;
                }
                result += (chain * (chain + 1L)) / 2L;
            }
        }
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
        try (MysteriousCrime instance = new MysteriousCrime()) {
            instance.solve();
        }
    }
}
