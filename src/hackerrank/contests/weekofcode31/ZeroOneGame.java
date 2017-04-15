package hackerrank.contests.weekofcode31;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ZeroOneGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int g = in.ni();
        while (g-- > 0) {
            int n = in.ni();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            play(x);
        }
    }
    
    private void play(int[] x) {
        int n = x.length;
        boolean[] removed = new boolean[n];
        int zeroes = 0, ones = 0;
        for (int i = 1; i < n - 1; i++) {
            if (x[i - 1] == 0 && x[i + 1] == 0) {
                if (x[i] == 1) {
                    ones++;
                    removed[i] = true;
                }
            }
        }
        int[] y = new int[n - ones];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                y[idx++] = x[i];
            }
        }
        n = y.length;
        for (int i = 1; i < n - 1; i++) {
            if (y[i - 1] == 0 && y[i + 1] == 0) {
                if (y[i] == 0) {
                    zeroes++;
                }
            }
        }
        int result = ones ^ zeroes;
        out.println((result & 1) == 1 ? "Alice" : "Bob");
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
        try (ZeroOneGame instance = new ZeroOneGame()) {
            instance.solve();
        }
    }
}
