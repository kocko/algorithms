package codeforces.contests501_600.problemset558;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AmrAndTheLargeArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int n = in.ni(), MAX = 1000001;
        int beauty = 0, left = 0, right = MAX;
        int[] first = new int[MAX], last = new int[MAX], count = new int[MAX];
        for (int i = 1; i <= n; i++) {
            int x = in.ni();
            if (first[x] == 0) {
                first[x] = i;
            }
            last[x] = i;
            count[x]++;
            if (count[x] == beauty) {
                if (right - left > last[x] - first[x]) {
                    left = first[x];
                    right = last[x];
                }
            } else if (count[x] > beauty) {
                beauty = count[x];
                left = first[x];
                right = last[x];
            }
        }
        out.println(left + " " + right);
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
        try (AmrAndTheLargeArray instance = new AmrAndTheLargeArray()) {
            instance.solve();
        }
    }
}
