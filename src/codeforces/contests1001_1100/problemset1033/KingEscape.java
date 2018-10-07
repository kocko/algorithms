package codeforces.contests1001_1100.problemset1033;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class KingEscape implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int ax = in.ni() - 1, ay = in.ni() - 1, bx = in.ni() - 1, by = in.ni() - 1, cx = in.ni() - 1, cy = in.ni() - 1;
        boolean[][] danger = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                danger[i][j] = ((i == ax || j == ay) || (j - i == ay - ax) || (i + j == ax + ay));
            }
        }
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{bx, by});
        visited[bx][by] = true;
        
        while (!deque.isEmpty()) {
            int[] top = deque.pollFirst();
            for (int[] d : dir) {
                int bx_ = top[0] + d[0], by_ = top[1] + d[1];
                if (bx_ >= 0 && bx_ < n && by_ >= 0 && by_ < n && !visited[bx_][by_] && !danger[bx_][by_]) {
                    deque.offer(new int[]{bx_, by_});
                    visited[bx_][by_] = true;
                }
            }
        }
        out.println(visited[cx][cy] ? "YES" : "NO");
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
        try (KingEscape instance = new KingEscape()) {
            instance.solve();
        }
    }
}
