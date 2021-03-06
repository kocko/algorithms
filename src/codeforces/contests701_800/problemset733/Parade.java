package codeforces.contests701_800.problemset733;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Parade implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] l = new int[n + 1], r = new int[n + 1];
        int left = 0, right = 0;
        for (int i = 1; i <= n; i++) {
            l[i] = in.ni();
            r[i] = in.ni();
            left += l[i];
            right += r[i];
        }
        int result = Math.abs(left - right);
        int index = 0;
        for (int i = 1; i <= n; i++) {
            int x = left, y = right;
            x -= l[i]; x += r[i];
            y -= r[i]; y += l[i];
            if (Math.abs(x - y) > result) {
                result = Math.abs(x - y);
                index = i;
            }
        }
        out.println(index);
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
        try (Parade instance = new Parade()) {
            instance.solve();
        }
    }
}
