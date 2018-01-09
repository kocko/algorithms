package acm.regionals.year2016.southpacific;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class AnticlockwiseMotion implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] a = coordinates(in.ni()), b = coordinates(in.ni());
        out.println(abs(a[0] - b[0]) + abs(a[1] - b[1]));
    }

    private int[] coordinates(int n) {
        int size = (int) sqrt(n);
        if (size * size < n) size++;
        if (size % 2 == 0) size++;

        if (size == 1) return new int[]{0, 0};

        int current = (size - 2) * (size - 2) + 1;

        int y = (1 - size) / 2, x = y + 1;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int idx = 0;
        while (current < n) {
            for (int i = 0; i < size - 1; i++) {
                if (current == n) break;
                if (i == size - 2) {
                    idx++;
                }
                x += dir[idx][0];
                y += dir[idx][1];
                current++;
            }
        }
        return new int[]{x, y};
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
        try (AnticlockwiseMotion instance = new AnticlockwiseMotion()) {
            instance.solve();
        }
    }
}
