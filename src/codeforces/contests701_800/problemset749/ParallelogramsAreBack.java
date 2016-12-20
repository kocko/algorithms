package codeforces.contests701_800.problemset749;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ParallelogramsAreBack implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x1 = in.ni(), y1 = in.ni();
        int x2 = in.ni(), y2 = in.ni();
        int x3 = in.ni(), y3 = in.ni();
        out.println(3);
        out.println((x2 + x3 - x1) + " " + (y2 + y3 - y1));
        out.println((x3 + x1 - x2) + " " + (y3 + y1 - y2));
        out.println((x1 + x2 - x3) + " " + (y1 + y2 - y3));
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
        try (ParallelogramsAreBack instance = new ParallelogramsAreBack()) {
            instance.solve();
        }
    }
}
