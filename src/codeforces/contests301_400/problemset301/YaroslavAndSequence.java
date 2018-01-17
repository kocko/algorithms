package codeforces.contests301_400.problemset301;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class YaroslavAndSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        int total = 2 * n - 1;
        Integer[] x = new Integer[total];
        int negative = 0;
        for (int i = 0; i < total; i++) {
            x[i] = in.ni();
            if (x[i] < 0) {
                negative++;
            }
        }
        Arrays.sort(x, Comparator.comparingInt(Math::abs));
        visited = new boolean[n];
        recurse(negative);
        int min = n + 1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                min = i;
                break;
            }
        }
        int sum = 0;
        for (int i = 0; i < min; i++) {
            sum -= abs(x[i]);
        }
        for (int i = min; i < total; i++) {
            sum += abs(x[i]);
        }
        out.println(sum);
    }

    private int n;
    private boolean[] visited;

    private void recurse(int negative) {
        negative %= n;
        if (!visited[negative]) {
            visited[negative] = true;
            if (negative > 0) {
                recurse(negative + n - 2);
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
        try (YaroslavAndSequence instance = new YaroslavAndSequence()) {
            instance.solve();
        }
    }
}
