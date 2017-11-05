package codeforces.contests001_100.problemset094;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Friends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean[][] know = new boolean[6][6];
        int m = in.ni();
        while (m-- > 0) {
            int u = in.ni(), v = in.ni();
            know[u][v] = know[v][u] = true;
        }
        boolean all = false, none = false;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (i != j && i != k && k != j) {
                        all |= (know[i][j] && know[i][k] && know[j][k]);
                        none |= (!know[i][j] && !know[i][k] && !know[j][k]);
                    }
                }
            }
        }
        out.println(all || none ? "WIN" : "FAIL");
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
        try (Friends instance = new Friends()) {
            instance.solve();
        }
    }
}
