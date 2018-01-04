package codeforces.contests201_300.problemset286;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(1);
            return;
        }
        if (n % 4 >= 2) {
            out.println(-1);
            return;
        }
        int[] result = new int[n + 1];
        if (n % 2 == 1) result[(n + 1) / 2] = (n + 1) / 2;
        for (int idx = 1; idx < n / 2; idx += 2) {
            int value = idx + 1;
            int i = idx;
            for (int j = 0; j < 4; j++) {
                result[i] = value;
                int next = n - i + 1;
                i = value;
                value = next;
            }
        }
        for (int i = 1; i <= n; i++) {
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
        try (LuckyPermutation instance = new LuckyPermutation()) {
            instance.solve();
        }
    }
}
