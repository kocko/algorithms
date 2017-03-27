package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int tests = in.ni();
        while (tests-- > 0) {
            int n = in.ni(), m = in.ni(), k = 1 << n;
            int[] tree = new int[k << 1];
            while (m-- > 0) {
                int next = in.ni();
                tree[k + next - 1] = 1;
            }
            int result = 0;
            for (int i = k - 1; i > 0; i--) {
                result += tree[i << 1] ^ tree[i << 1 | 1];
                tree[i] = tree[i << 1] & tree[i << 1 | 1];
            }
            out.println(result);
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
