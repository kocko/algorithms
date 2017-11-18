package csadademy.problemset057;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class FoxesOnAWheel implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] type = new int[n + 1];
        for (int i = 0; i < k; i++) {
            type[in.ni()] = 1;
        }
        for (int i = 0; i < k; i++) {
            type[in.ni()] = 2;
        }
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (type[i] + type[i + 1] == 3) {
                x++;
                i++;
            }
        }
        int y = 0;
        if (type[1] + type[n] == 3) {
            y++;
        }
        for (int i = n - 1; i > 2; i--) {
            if (type[i] + type[i - 1] == 3) {
                y++;
                i--;
            }
        }
        
        out.println(2 * k - max(x, y));
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
        try (FoxesOnAWheel instance = new FoxesOnAWheel()) {
            instance.solve();
        }
    }
}
