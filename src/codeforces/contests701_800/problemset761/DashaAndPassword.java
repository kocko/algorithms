package codeforces.contests701_800.problemset761;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DashaAndPassword implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final int ALPHA = 0, DIGIT = 1, SPECIAL = 2, INF = 100000;
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int[][] dist = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < n; i++) {
            char[] next = grid[i];
            for (int j = 0; j < m; j++) {
                int type = findType(next[j]);
                dist[i][type] = Math.min(dist[i][type], Math.min(j, m - j));
            }
        }
        int result = INF - 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        result = Math.min(dist[i][ALPHA] + dist[j][DIGIT] + dist[k][SPECIAL], result);
                    }
                }
            }
        }
        out.println(result);
    }
    
    private int findType(char x) {
        if (x >= 'a' && x <= 'z') return ALPHA;
        else if (x >= '0' && x <= '9') return DIGIT;
        return SPECIAL;
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
        try (DashaAndPassword instance = new DashaAndPassword()) {
            instance.solve();
        }
    }
}
