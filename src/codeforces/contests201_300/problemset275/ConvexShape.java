package codeforces.contests201_300.problemset275;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class ConvexShape implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        List<int[]> black = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') black.add(new int[]{i, j});
            }
        }
        boolean ok = true;
        for (int i = 0; i < black.size(); i++) {
            for (int j = i + 1; j < black.size(); j++) {
                int[] a = black.get(i), b = black.get(j);
                if (a[0] == b[0]) {
                    for (int k = min(a[1], b[1]); k <= max(a[1], b[1]); k++) ok &= grid[a[0]][k] == 'B';
                } else if (a[1] == b[1]) {
                    for (int k = min(a[0], b[0]); k <= max(a[0], b[0]); k++) ok &= grid[k][a[1]] == 'B';
                } else {
                    boolean left = true, down = true, right = true, up = true;
                    for (int k = min(a[0], b[0]); k <= max(a[0], b[0]); k++) {
                        left  &= grid[k][min(a[1], b[1])] == 'B';
                        right &= grid[k][max(a[1], b[1])] == 'B';
                    }
                    for (int k = min(a[1], b[1]); k <= max(a[1], b[1]); k++) {
                        up   &= grid[min(a[0], b[0])][k] == 'B';
                        down &= grid[max(a[0], b[0])][k] == 'B';
                    }
                    if ((a[0] < b[0] && a[1] < b[1]) || (a[0] > b[0] && a[1] > b[1])) ok &= ((up && right) || (left && down));
                    else ok &= ((up && left) || (right && down));
                }
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (ConvexShape instance = new ConvexShape()) {
            instance.solve();
        }
    }
}
