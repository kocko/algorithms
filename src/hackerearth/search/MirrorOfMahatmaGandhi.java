package hackerearth.search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MirrorOfMahatmaGandhi implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] next = in.next().toCharArray();
            int n = next.length, limit = n % 2 == 1 ? n / 2 + 1 : n / 2;
            boolean ok = true;
            for (int i = 0; i <= limit; i++) {
                if (next[i] == '0' || next[i] == '1' || next[i] == '8') {
                    if (next[i] != next[n - i - 1]) {
                        ok = false;
                        break;
                    }
                } else {
                    ok = false;
                }
            }
            out.println(ok ? "YES" : "NO");
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
        try (MirrorOfMahatmaGandhi instance = new MirrorOfMahatmaGandhi()) {
            instance.solve();
        }
    }
}
