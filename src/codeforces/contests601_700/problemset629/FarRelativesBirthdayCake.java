package codeforces.contests601_700.problemset629;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FarRelativesBirthdayCake implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'C') c++;
            }
            result += c * (c - 1) / 2;
        }
        for (int j = 0; j < n; j++) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 'C') c++;
            }
            result += c * (c - 1) / 2;
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

    public static void main(String[] args) {
        new FarRelativesBirthdayCake().solve();
    }
}
