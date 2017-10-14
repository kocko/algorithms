package codeforces.contests201_300.problemset279;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PointOnSpiral implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni();
        if (x == 0 && y == 0) {
            out.println(0);
            return;
        }
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int idx = 0;
        int a = 0, b = 0, result = 0, times = 1;
        out: while (true) {
            int[] d = dir[idx];
            idx = (idx + 1) % 4;
            for (int i = 0; i < times; i++) {
                a += d[0];
                b += d[1];
                if (a == x && b == y) break out;
            }
            result++;
            d = dir[idx];
            idx = (idx + 1) % 4;
            for (int i = 0; i < times; i++) {
                a += d[0];
                b += d[1];
                if (a == x && b == y) break out;
            }
            result++;
            times++;
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
        try (PointOnSpiral instance = new PointOnSpiral()) {
            instance.solve();
        }
    }
}
