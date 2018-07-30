package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cars implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1], pos = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            x[i] = in.ni();
            pos[x[i]] = i;
        }
        int result = 0;

        while (pos[0] != 0) {
            int from = pos[0], next = pos[pos[0]], value = x[next];
            x[next] = x[pos[0]] ^ x[next] ^ (x[pos[0]] = x[next]);
            pos[0] = next;
            pos[value] = from;
            result++;
        }
        for (int i = 1; i <= n; i++) {
            if (x[i] != i) {
                int cycle = 1, current = i, next = x[i];
                while (next != i) {
                    int a = x[current], b = x[next];
                    cycle++;
                    x[next] = a;
                    x[current] = b;
                    next = x[current];
                }
                result += cycle + 1;
            }
        }
        out.println(10 * result);
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
        try (Cars instance = new Cars()) {
            instance.solve();
        }
    }
}
