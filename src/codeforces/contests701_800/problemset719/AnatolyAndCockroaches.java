package codeforces.contests701_800.problemset719;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnatolyAndCockroaches implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] c = in.next().toCharArray();
        int x = 0, y = 0;
        //rbrbrbrbrbr...
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && c[i] == 'b') {
                x++;
            }
            if (i % 2 == 1 && c[i] == 'r') {
                y++;
            }
        }
        int a = Math.max(x, y);
        x = y = 0;
        //brbrbrbrbrbr...
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && c[i] == 'r') {
                x++;
            }
            if (i % 2 == 1 && c[i] == 'b') {
                y++;
            }
        }
        int b = Math.max(x, y);
        out.println(Math.min(a, b));
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
        try (AnatolyAndCockroaches instance = new AnatolyAndCockroaches()) {
            instance.solve();
        }
    }
}
