package codeforces.contests701_800.problemset729;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Spotlights implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] x = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = in.ni();
            }
        }
        int result = 0;
        for (int[] row : x) {
            boolean ok = row[m - 1] == 1;
            for (int i = m - 2; i >= 0; i--) {
                if (row[i] == 1) {
                    ok = true;
                } else {
                    if (ok) result++;
                }
            }
            ok = row[0] == 1;
            for (int i = 1; i < m; i++) {
                if (row[i] == 1) {
                    ok = true;
                } else {
                    if (ok) result++;
                }
            }
        }
        
        for (int j = 0; j < m; j++) {
            boolean ok = x[n - 1][j] == 1;
            for (int i = n - 2; i >= 0; i--) {
                if (x[i][j] == 1) {
                    ok = true;
                } else {
                    if (ok) result++;
                }
            }
            ok = x[0][j] == 1;
            for (int i = 1; i < n; i++) {
                if (x[i][j] == 1) {
                    ok = true;
                } else {
                    if (ok) result++;
                }
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
        try (Spotlights instance = new Spotlights()) {
            instance.solve();
        }
    }
}
