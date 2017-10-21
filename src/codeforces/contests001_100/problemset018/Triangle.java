package codeforces.contests001_100.problemset018;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Triangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] x = new int[3], y = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = in.ni();
            y[i] = in.ni();
        }
        if (isRight(x, y)) {
            out.println("RIGHT");
        } else if (isAlmostRight(x, y)) {
            out.println("ALMOST");
        } else {
            out.println("NEITHER");
        }
    }

    private boolean isRight(int[] x, int[] y) {
        boolean result = check(x[0], y[0], x[1], y[1], x[2], y[2]);
        result |= check(x[1], y[1], x[2], y[2], x[0], y[0]);
        result |= check(x[2], y[2], x[0], y[0], x[1], y[1]);
        return result;
    }

    private boolean check(int x1, int y1, int x2, int y2, int x3, int y3) {
        boolean notSame = !(x1 == x2 && y1 == y2) && !(x1 == x3 && y1 == y3) && !(x2 == x3 && y2 == y3);
        boolean size = ((x1 - x2) * (x1 - x2) +
                        (y1 - y2) * (y1 - y2) +
                        (x3 - x2) * (x3 - x2) +
                        (y3 - y2) * (y3 - y2) ==
                        (x1 - x3) * (x1 - x3) +
                        (y1 - y3) * (y1 - y3));
        boolean notOnOneLine = (x1 != x2 || x2 != x3) && (y1 != y2 || y2 != y3);
        return notSame && size && notOnOneLine;
    }

    private boolean isAlmostRight(int[] x, int[] y) {
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        int[] x_ = new int[3], y_ = new int[3];
        for (int i = 0; i < 3; i++) {
            x_[i] = x[i];
            y_[i] = y[i];
        }
        for (int i = 0; i < 3; i++) {
            for (int[] m : move) {
                x_[i] += m[0];
                y_[i] += m[1];
                result |= isRight(x_, y_);
                x_[i] -= m[0];
                y_[i] -= m[1];
            }
        }
        return result;
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
        try (Triangle instance = new Triangle()) {
            instance.solve();
        }
    }
}
