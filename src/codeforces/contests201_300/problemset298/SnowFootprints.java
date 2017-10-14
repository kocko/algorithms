package codeforces.contests201_300.problemset298;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SnowFootprints implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int firstRight = -1, lastRight = -1;
        int firstLeft = -1, lastLeft = -1;
        for (int i = 0; i < n; i++) {
            if (x[i] == 'R') {
                if (firstRight == -1) firstRight = i + 1;
                else lastRight = i + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (x[i] == 'L') {
                if (firstLeft == -1) firstLeft = i + 1;
                else lastLeft = i + 1;
            }
        }
        if (firstRight != -1) {
            out.println(firstRight + " " + ((lastRight == - 1) ? firstRight + 1 : lastRight + 1));
        } else {
            out.println(((lastLeft == -1) ? firstLeft: lastLeft) + " " + (firstLeft - 1));
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
        try (SnowFootprints instance = new SnowFootprints()) {
            instance.solve();
        }
    }
}
