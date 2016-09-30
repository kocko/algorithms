package codeforces.contests701_800.problemset701;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TheyAreEverywhere implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        Set<Character> chars = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            char c = x[i];
            if (!chars.contains(c)) {
                chars.add(c);
            }
        }
        int[] len = new int[n];
        for (Character c : chars) {
            int last = -1;
            for (int i = 0; i < n; i++) {
                if (x[i] == c) {
                    last = i;
                }
                if (last == -1) {
                    len[i] = n + 5;
                } else {
                    len[i] = Math.max(len[i], i - last + 1);
                }
            }
        }
        int min = n + 5;
        for (int i : len) {
            if (i < min) {
                min = i;
            }
        }
        out.println(min);
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
        try (TheyAreEverywhere instance = new TheyAreEverywhere()) {
            instance.solve();
        }
    }
}
