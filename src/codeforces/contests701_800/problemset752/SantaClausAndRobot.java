package codeforces.contests701_800.problemset752;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SantaClausAndRobot implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int result = 1;
        char h = '\u0000', l = '\u0000';
        if (x[0] == 'L' || x[0] == 'R') l = x[0];
        if (x[0] == 'U' || x[0] == 'D') h = x[0];
        for (int i = 1; i < n; i++) {
            char c = x[i];
            if (c == 'R' || c == 'L') {
                if (l == '\u0000') {
                    l = c;
                } else if (c != l) {
                    result++;
                    l = c;
                    h = '\u0000';
                }
            }
            if (c == 'U' || c == 'D') {
                if (h == '\u0000') {
                    h = c;
                } else if (c != h) {
                    result++;
                    h = c;
                    l = '\u0000';
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
        try (SantaClausAndRobot instance = new SantaClausAndRobot()) {
            instance.solve();
        }
    }
}
