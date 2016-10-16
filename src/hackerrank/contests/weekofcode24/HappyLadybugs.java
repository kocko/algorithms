package hackerrank.contests.weekofcode24;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HappyLadybugs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            char[] x = in.next().toCharArray();
            boolean happy = true;
            boolean modifiable = false;
            for (int i = 0; i < n; i++) {
                if (x[i] == '_') {
                    modifiable = true;
                    break;
                }
            }
            if (!modifiable) {
                for (int i = 0; i < n; i++) {
                    char value = x[i];
                    boolean h = false;
                    if (i - 1 >= 0) {
                        h = value == x[i - 1];
                    }
                    if (i + 1 < n) {
                        h |= value == x[i + 1];
                    }
                    if (!h) {
                        happy = false;
                        break;
                    }
                }
                out.println(happy ? "YES" : "NO");
            } else {
                Arrays.sort(x);
                for (int i = 0; i < n; i++) {
                    char value = x[i];
                    boolean h = false;
                    if (value != '_') {
                        if (i - 1 >= 0) {
                            h = value == x[i - 1];
                        }
                        if (i + 1 < n) {
                            h |= value == x[i + 1];
                        }
                    } else {
                        continue;
                    }
                    if (!h) {
                        happy = false;
                        break;
                    }
                }
                out.println(happy ? "YES" : "NO");
            }
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
        try (HappyLadybugs instance = new HappyLadybugs()) {
            instance.solve();
        }
    }
}
