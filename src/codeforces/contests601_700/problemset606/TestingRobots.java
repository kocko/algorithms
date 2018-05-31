package codeforces.contests601_700.problemset606;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TestingRobots implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni(), xo = in.ni(), yo = in.ni();
        char[] c = in.next().toCharArray();
        int n = c.length;
        boolean[][] used = new boolean[x + 1][y + 1];
        int[] result = new int[n + 1];
        Map<Character, int[]> map = new HashMap<Character, int[]>() {{
           put('U', new int[]{-1, 0});
           put('D', new int[]{1, 0});
           put('L', new int[]{0, -1});
           put('R', new int[]{0, 1});
        }};
        used[xo][yo] = true;
        result[0] = 1;
        for (int i = 0; i < n; i++) {
            int[] d = map.get(c[i]);
            if (xo + d[0] > 0 && xo + d[0] <= x && yo + d[1] > 0 && yo + d[1] <= y) {
                if (!used[xo + d[0]][yo + d[1]]) {
                    result[i + 1]++;
                    used[xo + d[0]][yo + d[1]] = true;
                }
                xo += d[0];
                yo += d[1];
            }
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (!used[i][j]) result[n]++;
            }
        }
        for (int i = 0; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (TestingRobots instance = new TestingRobots()) {
            instance.solve();
        }
    }
}
