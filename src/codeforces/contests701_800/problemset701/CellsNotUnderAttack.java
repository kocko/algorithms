package codeforces.contests701_800.problemset701;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CellsNotUnderAttack implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[] r = new boolean[n + 1], c = new boolean[n + 1];
        long row = n, col = n;
        for (int i = 0; i < m; i++) {
            int x = in.ni(), y = in.ni();
            if (!r[x]) {
                r[x] = true;
                row--;
            }
            if (!c[y]) {
                c[y] = true;
                col--;
            }
            out.print(row * col + " ");
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
        try (CellsNotUnderAttack instance = new CellsNotUnderAttack()) {
            instance.solve();
        }
    }
}
