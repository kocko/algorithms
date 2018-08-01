package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class E2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = in.next().toCharArray();
        }
        boolean[][] partOfStar = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*') {
                    int up = i - 1, down = i + 1, left = j - 1, right = j + 1;
                    if (up >= 0 && down < n && left >= 0 && right < m) {
                        if (x[up][j] == '*' && x[down][j] == '*' && x[i][left] == '*' && x[i][right] == '*') {
                            partOfStar[i][j] = partOfStar[i][left] = partOfStar[i][right] = partOfStar[up][j] = partOfStar[down][j] = true;
                            dist[i][left] = dist[i][right] = dist[up][j] = dist[down][j] = 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*') {
                    int up = i - 1, down = i + 1, left = j - 1, right = j + 1;
                    if (up >= 0 && down < n && left >= 0 && right < m) {
                        if (partOfStar[i][left]) {
                            partOfStar[i][j] = true;
                            dist[i][j] = dist[i][left] + 1;
                        } else if (partOfStar[i][right]) {
                            partOfStar[i][j] = true;
                            dist[i][j] = dist[i][right] + 1;
                        } else if (partOfStar[up][j]) {
                            partOfStar[i][j] = true;
                            dist[i][j] = dist[up][j] + 1;
                        } else if (partOfStar[down][j]) {
                            partOfStar[i][j] = true;
                            dist[i][j] = dist[down][j] + 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*' && !partOfStar[i][j]) {
                    out.println(-1);
                    return;
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        boolean[] added = new boolean[1000005];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == '*') {
                    int d = dist[i][j];
                    int p = i + d, q = j + d;
                    int idx = p * n + q;
                    if (!added[idx]) {
                        result.add(new int[]{p, q, d});
                        added[idx] = true;
                    }
                }
            }
        }
        out.println(result.size());
        for (int[] star : result) {
            for (int i : star) {
                out.print(i);
                out.print(' ');
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
        try (E2 instance = new E2()) {
            instance.solve();
        }
    }
}
