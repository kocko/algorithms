package codeforces.contests1001_1100.problemset1065;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItEqual implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int MAX = (int) 2e5;
        int n = in.ni();
        long k = in.nl();
        int[] height = new int[n];
        int[] cnt = new int[MAX + 1];
        for (int i = 0; i < n; i++) {
            height[i] = in.ni();
            cnt[height[i]]++;
        }
        for (int i = MAX - 1; i >= 0; i--) {
            cnt[i] += cnt[i + 1];
        }
        int cuts = 0, idx = MAX;
        long current = 0;
        while (cnt[idx] < n) {
            int blocks = cnt[idx];
            if (current + blocks <= k) {
                current += blocks;
            } else {
                cuts++;
                current = blocks;
            }
            idx--;
        }
        if (current != 0) cuts++;
        out.println(cuts);
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
        try (MakeItEqual instance = new MakeItEqual()) {
            instance.solve();
        }
    }
}
