package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Lotto implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        char[] target = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean right = true;
                if (j + k > m) right = false;
                else {
                    for (int p = j, q = 0; p < j + k; p++, q++) {
                        right &= grid[i][p] == target[q];
                    }
                }
                boolean down = true;
                if (i + k > n) down = false;
                else {
                    for (int p = i, q = 0; p < i + k; p++, q++) {
                        down &= grid[p][j] == target[q];
                    }
                }
                if (right || down) {
                    out.println("Winning");
                    return;
                }
            }
        }
        out.println("Losing");
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
        try (Lotto instance = new Lotto()) {
            instance.solve();
        }
    }
}
