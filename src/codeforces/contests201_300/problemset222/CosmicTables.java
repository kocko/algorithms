package codeforces.contests201_300.problemset222;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CosmicTables implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), q = in.ni();
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = in.ni();
            }
        }
        int[] row = new int[n];
        for (int i = 0; i < n; i++) row[i] = i;
        int[] col = new int[m];
        for (int i = 0; i < m; i++) col[i] = i;
        while (q-- > 0) {
            char type = in.next().charAt(0);
            int x = in.ni() - 1, y = in.ni() - 1;
            if (type == 'c') {
                int temp = col[x];
                col[x] = col[y];
                col[y] = temp;
            } else if (type == 'r') {
                int temp = row[x];
                row[x] = row[y];
                row[y] = temp;
            } else {
                out.println(data[row[x]][col[y]]);
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
        try (CosmicTables instance = new CosmicTables()) {
            instance.solve();
        }
    }
}
