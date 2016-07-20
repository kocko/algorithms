package codeforces.contests600_699.problemset699;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneBomb implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        String[] grid = new String[n];
        int[] rows = new int[n];
        int[] cols = new int[m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String next = in.next();
            grid[i] = next;
            for (int j = 0; j < m; j++) {
                if (next.charAt(j) == '*') {
                    rows[i]++;
                    cols[j]++;
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '.') {
                    if (rows[i] + cols[j] == count || rows[i] + cols[j] == count + 1) {
                        out.println("YES");
                        out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                } else {
                    if (rows[i] + cols[j] - 1 == count) {
                        out.println("YES");
                        out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        out.println("NO");
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
        try (OneBomb instance = new OneBomb()) {
            instance.solve();
        }
    }
}
