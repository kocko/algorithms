package codeforces.contests401_500.problemset454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittlePonyAndSortByShift implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int i = 1;
        int a = x[0];
        for (; i < n; i++) {
            if (x[i] < x[i - 1]) {
                break;
            }
        }
        if (i == n) {
            out.println(0);
            return;
        }
        int max_b = x[i], result = 1;
        i++;
        for (; i < n; i++) {
            if (x[i] < x[i - 1]) {
                break;
            } else {
                max_b = x[i];
                result++;
            }
        }
        if (i < n) {
            out.println(-1);
        } else {
            if (max_b > a) out.println(-1);
            else out.println(result);
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
        try (LittlePonyAndSortByShift instance = new LittlePonyAndSortByShift()) {
            instance.solve();
        }
    }
}
