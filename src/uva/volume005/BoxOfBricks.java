package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class BoxOfBricks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, test = 1;
        while ((n = in.ni()) != 0) {
            int[] x = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
                total += x[i];
            }
            int height = total / n, moves = 0;
            for (int i = 0; i < n; i++) {
                moves += abs(x[i] - height);
            }
            out.printf("Set #%d\n", test++);
            out.printf("The minimum number of moves is %d.\n", moves / 2);
            out.println();
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
        try (BoxOfBricks instance = new BoxOfBricks()) {
            instance.solve();
        }
    }
}
