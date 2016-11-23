package codeforces.contests201_300.problemset231;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicBox implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni(), z = in.ni();
        int X = in.ni(), Y = in.ni(), Z = in.ni();
        int[] a = new int[7];
        for (int i = 1; i <= 6; i++) {
            a[i] = in.ni();
        }
        int s = 0;
        if (y < 0) s += a[1];
        if (y > Y) s += a[2];
        if (z < 0) s += a[3];
        if (z > Z) s += a[4];
        if (x < 0) s += a[5];
        if (x > X) s += a[6];
        out.println(s);
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
        try (MagicBox instance = new MagicBox()) {
            instance.solve();
        }
    }
}
