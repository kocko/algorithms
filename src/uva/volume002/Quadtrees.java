package uva.volume002;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Quadtrees implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] x = in.next().toCharArray(), y = in.next().toCharArray();
            int[] a = new int[1024], b = new int[1024];
            pointer = 0;
            idx = 0;
            propagate(x, a, -1, 0);

            pointer = 0;
            idx = 0;
            propagate(y, b, -1, 0);
            int result = 0;
            for (int i = 0; i < 1024; i++) {
                result += (a[i] | b[i]);
            }
            out.printf("There are %d black pixels.", result);
            out.println();
        }
    }

    private int pointer, idx;

    private void propagate(char[] arr, int[] result, int color, int level) {
        int next = color;
        if (level == 5) {
            if (color == -1) {
                color = arr[pointer++] == 'f' ? 1 : 0;
            }
            result[idx++] = color;
        } else {
            if (color == -1) {
                next = 0;
                if (arr[pointer] == 'p') {
                    next = -1;
                } else if (arr[pointer] == 'f') {
                    next = 1;
                }
                ++pointer;
            }
            for (int i = 0; i < 4; i++) {
                propagate(arr, result, next, level + 1);
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
        try (Quadtrees instance = new Quadtrees()) {
            instance.solve();
        }
    }
}
