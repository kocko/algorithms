package codeforces.contests201_300.problemset218;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MountainScenery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            x[i] = in.ni();
        }
        int[] result = new int[2 * n + 1];
        result[0] = x[0];
        result[2 * n] = x[2 * n];
        for (int i = 1; i < 2 * n; i++) {
            if (i % 2 == 1 && x[i] - x[i - 1] > 1 && x[i] - x[i + 1] > 1 && k > 0) {
                result[i] = x[i] - 1;
                k--;
            } else {
                result[i] = x[i];
            }
        }
        for (int i = 0; i < 2 * n + 1; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (MountainScenery instance = new MountainScenery()) {
            instance.solve();
        }
    }
}
