package codeforces.gyms.gym101336;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PaintingTheWall implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni(), k = in.ni();
            int[][] wall = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    wall[i][j] = in.ni();
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                int current = 0;
                for (int j = 0; j < m; j++) {
                    if (wall[i][j] != 0) {
                        current++;
                    } else {
                        max = Math.max(current, max);
                        current = 0;
                    }
                }
                max = Math.max(max, current);
            }
            for (int i = 0; i < m; i++) {
                int current = 0;
                for (int j = 0; j < n; j++) {
                    if (wall[j][i] != 0) {
                        current++;
                    } else {
                        max = Math.max(current, max);
                        current = 0;
                    }
                }
                max = Math.max(max, current);
            }
            if (max <= k) {
                if (max != 0) {
                    int[][] result = new int[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[i][j] = (i + j) % max + 1;
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (wall[i][j] == 0) {
                                result[i][j] = 0;
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
                } else {
                    out.println("YES");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            out.print(wall[i][j] + " ");
                        }
                        out.println();
                    }
                }
            } else {
                out.println("NO");
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
        try (PaintingTheWall instance = new PaintingTheWall()) {
            instance.solve();
        }
    }
}
