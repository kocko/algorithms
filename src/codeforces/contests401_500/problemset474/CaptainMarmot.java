package codeforces.contests401_500.problemset474;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.util.Arrays.sort;

public class CaptainMarmot implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            long[][] co = new long[4][4];
            for (int i = 0; i < 4; i++) {
                co[i][0] = in.nl();
                co[i][1] = in.nl();
                co[i][2] = in.nl();
                co[i][3] = in.nl();
            }
            int result = 17;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            if (isSquare(co)) {
                                result = min(i + j + l + m, result);
                            }
                            rotate(co[3]);
                        }
                        rotate(co[2]);
                    }
                    rotate(co[1]);
                }
                rotate(co[0]);
            }
            out.println(result == 17 ? -1 : result);
        }
    }

    private void rotate(long[] p) {
        long x = p[0], y = p[1];
        long a = p[2], b = p[3];
        long nx = -(y - b) + a;
        long ny = (x - a) + b;
        p[0] = nx;
        p[1] = ny;
    }

    private boolean isSquare(long[][] points) {
        long[] dist = new long[6];
        int idx = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long x = points[i][0] - points[j][0];
                long y = points[i][1] - points[j][1];
                dist[idx++] = x * x + y * y;
            }
        }
        sort(dist);
        return dist[0] > 0 && dist[3] == dist[0] && dist[4] == 2 * dist[0] && dist[4] == dist[5];
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
        try (CaptainMarmot instance = new CaptainMarmot()) {
            instance.solve();
        }
    }
}
