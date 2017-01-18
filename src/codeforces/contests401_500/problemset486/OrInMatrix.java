package codeforces.contests401_500.problemset486;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OrInMatrix implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] x = new int[n][m];
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = in.ni();
                result[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        result[i][k] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        result[k][j] = 0;
                    }
                }
            }
        }
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    temp[i][j] |= result[i][k];
                }
                for (int k = 0; k < n; k++) {
                    temp[i][j] |= result[k][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] != temp[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(result[i][j] + " ");
            }
            out.println();
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
        try (OrInMatrix instance = new OrInMatrix()) {
            instance.solve();
        }
    }
}
