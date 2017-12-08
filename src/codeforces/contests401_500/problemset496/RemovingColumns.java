package codeforces.contests401_500.problemset496;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RemovingColumns implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = in.next().toCharArray();
        }
        int result = 0;
        boolean[] ok = new boolean[n];
        for (int j = 0; j < m; j++) {
            boolean remove = false;
            for (int i = 1; i < n; i++) {
                if (!ok[i]) {
                    if (x[i][j] < x[i - 1][j]) {
                        remove = true;
                    }
                }
            }
            if (remove) {
                result++;
            } else {
                for (int i = 1; i < n; i++) {
                    if (!ok[i]) {
                        if (x[i][j] > x[i - 1][j]) {
                            ok[i] = true;
                        }
                    }
                }
            }
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
        try (RemovingColumns instance = new RemovingColumns()) {
            instance.solve();
        }
    }
}
