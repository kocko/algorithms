package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class MinimumKnightMoves implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            String from = in.next(), to = in.next();
            out.println(f(from.charAt(0) - 'a', from.charAt(1) - '1', to.charAt(0) - 'a', to.charAt(1) - '1'));
        }
    }

    private Integer[][][][] dist = new Integer[8][8][8][8];

    private int f(int x1, int y1, int x2, int y2) {
        if (x1 < 0 || x1 >= 8 || x2 < 0 || x2 >= 8 || y1 < 0 || y1 >= 8 || y2 < 0 || y2 >= 8) return -1;

        if (dist[x1][y1][x2][y2] != null) return dist[x1][y1][x2][y2];

        int[][] dir = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        boolean[][][][] visited = new boolean[8][8][8][8];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x1, y1});
        dist[x1][y1][x1][y1] = 0;
        visited[x1][y1][x1][y1] = true;
        while (!queue.isEmpty()) {
            int[] top = queue.pollFirst();
            for (int[] d : dir) {
                int x_ = top[0] + d[0];
                int y_ = top[1] + d[1];
                if (x_ >= 0 && x_ < 8 && y_ >= 0 && y_ < 8 && !visited[x1][y1][x_][y_]) {
                    dist[x1][y1][x_][y_] = dist[x1][y1][top[0]][top[1]] + 1;
                    queue.add(new int[]{x_, y_});
                    visited[x1][y1][x_][y_] = true;
                }
            }
        }
        return dist[x1][y1][x2][y2];
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
        try (MinimumKnightMoves instance = new MinimumKnightMoves()) {
            instance.solve();
        }
    }
}
