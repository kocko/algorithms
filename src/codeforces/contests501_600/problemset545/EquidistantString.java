package codeforces.contests501_600.problemset545;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EquidistantString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        char[] y = in.next().toCharArray();
        int n = x.length;
        int hamming = 0;
        for (int i = 0; i < n; i++) {
            hamming += (x[i] != y[i]) ? 1 : 0;
        }
        if ((hamming & 1) == 1) {
            out.println("impossible");
            return;
        }
        boolean copyX = true;
        for (int i = 0; i < n; i++) {
            if (x[i] == y[i]) {
                out.print(x[i]);
            } else {
                out.print(copyX ? x[i] : y[i]);
                copyX = !copyX;
            }
        }
        out.println();
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
        try (EquidistantString instance = new EquidistantString()) {
            instance.solve();
        }
    }
}
