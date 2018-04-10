package codeforces.contests801_900.problemset828;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class BlackSquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), min = min(m, n);
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int min_x = n, max_x = -1;
        int min_y = m, max_y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') {
                    min_x = min(min_x, i);
                    max_x = max(max_x, i);

                    min_y = min(min_y, j);
                    max_y = max(max_y, j);
                }
            }
        }
        if (min_x == n && max_x == -1 && min_y == m && max_y == -1) {
            out.println(1);
        } else {
            int size = max(max_x - min_x + 1, max_y - min_y + 1);
            if (size > n || size > m) {
                out.println(-1);
                return;
            }
            int ans = m * n + 1;
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    int temp = 0;
                    for (int k = i; k < i + size; k++) {
                        for (int l = j; l < j + size; l++) {
                            if (grid[k][l] == 'W') {
                                temp++;
                            }
                        }
                    }
                    if (temp < ans) ans = temp;
                }
            }
            out.println(ans);
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
        try (BlackSquare instance = new BlackSquare()) {
            instance.solve();
        }
    }
}
