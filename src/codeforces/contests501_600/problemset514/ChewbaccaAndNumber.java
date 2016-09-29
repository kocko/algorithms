package codeforces.contests501_600.problemset514;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChewbaccaAndNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] c = in.next().toCharArray();
        if (c[0] != '9') {
            c[0] = (char) ('0' + (Math.min('9' - c[0], c[0] - '0')));
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = (char) ('0' + Math.min(('9' - c[i]), c[i] - '0'));
        }
        for (char a : c) {
            out.print(a);
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
        try (ChewbaccaAndNumber instance = new ChewbaccaAndNumber()) {
            instance.solve();
        }
    }
}
