package hackerearth.codemonk.graphtheory;

import java.io.*;
import java.util.StringTokenizer;

public class MonkAtTheGraphFactory implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public void solve() {
        int n = in.ni(), x = n;
        int total = 0;
        while (x-- > 0) {
            total += in.ni();
        }
        if (total % 2 == 0 && total / 2 == n - 1) {
            out.println("Yes");
        } else {
            out.println("No");
        }
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

    public static void main(String[] args) {
        new MonkAtTheGraphFactory().solve();
    }
}
