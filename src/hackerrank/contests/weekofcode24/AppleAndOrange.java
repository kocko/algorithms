package hackerrank.contests.weekofcode24;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AppleAndOrange implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long s = in.nl(), t = in.nl(), a = in.nl(), b = in.nl(), m = in.nl(), n = in.nl();
        long orange = 0, apple = 0;
        for (int i = 0; i < m; i++) {
            long next = in.nl();
            long position = a + next;
            if (position >= s && position <= t) {
                apple++;
            }
        }
        for (int i = 0; i < n; i++) {
            long next = in.nl();
            long position = b + next;
            if (position >= s && position <= t) {
                orange++;
            }
        }
        out.println(apple);
        out.println(orange);
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
        try (AppleAndOrange instance = new AppleAndOrange()) {
            instance.solve();
        }
    }
}
