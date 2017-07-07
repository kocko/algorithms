package codeforces.contests501_600.problemset549;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FaceDetection implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = in.next().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                char[] t = {x[i][j], x[i + 1][j], x[i][j + 1], x[i + 1][j + 1]};
                boolean f = false, a = false, c = false, e = false;
                for (int k = 0; k < 4; k++) {
                    f |= t[k] == 'f';
                    a |= t[k] == 'a';
                    c |= t[k] == 'c';
                    e |= t[k] == 'e';
                }
                if (f & a & c & e) cnt++;
            }
        }
        out.println(cnt);
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
        try (FaceDetection instance = new FaceDetection()) {
            instance.solve();
        }
    }
}
