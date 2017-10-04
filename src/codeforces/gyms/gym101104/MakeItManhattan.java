package codeforces.gyms.gym101104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class MakeItManhattan implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int d = in.ni(), n = in.ni();
            int[][] grid = new int[d][d];
            for (int i = 0; i < n; i++) {
                int x = in.ni(), y = in.ni();
                grid[(x % d + d) % d][(y % d + d) % d]++;
            }
            int[] r = new int[d];
            int[] c = new int[d];
            for (int i = 0; i < d; i++) {
                for (int j = 0; j < d; j++) {
                    r[i] += grid[i][j];
                    c[j] += grid[i][j];
                }
            }
            int result = (int) 1e7;
            for (int i = 0; i < d; i++) {
                for (int j = 0; j < d; j++) {
                    result = Math.min(result, r[i] + c[j] - grid[i][j]);
                }
            }
            out.println(result);
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
        try (MakeItManhattan instance = new MakeItManhattan()) {
            instance.solve();
        }
    }
}
