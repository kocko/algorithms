package codeforces.contests301_400.problemset374;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class InnaAndPinkPony implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int m = in.ni();
        i = in.ni(); j = in.ni();
        a = in.ni(); b = in.ni();
        int ans = min(f(1, 1), min(f(1, m), min(f(n, 1), f(n, m))));
        if (ans == INF || (ans > 0 && (n <= a || m <= b))) {
            out.println("Poor Inna and pony!");
        } else {
            out.println(ans);
        }
    }

    private int i, j, a, b;
    private final int INF = (int) 1e9;

    private int f(int x, int y) {
        if ((i - x) % a == 0 && (j - y) % b == 0 && ((i - x) / a - (j - y) / b) % 2 == 0) {
            return max(abs((i - x) / a), abs((j - y) / b));
        }
        return INF;
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
        try (InnaAndPinkPony instance = new InnaAndPinkPony()) {
            instance.solve();
        }
    }
}
