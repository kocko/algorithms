package codeforces.contests101_200.problemset197;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LexicographicallyMaximumSubsequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray();
        boolean[] has = new boolean[26];
        for (char c : s) {
            has[c - 'a'] = true;
        }
        int index = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (has[i]) {
                list.add((char)('a' + i));
            }
        }
        int lastIndex = 0;
        StringBuilder result = new StringBuilder();
        for (Character c : list) {
            for (int i = lastIndex; i < s.length; i++) {
                if (s[i] == c) {
                    result.append(c);
                    lastIndex = i;
                }
            }
        }
        out.println(result);
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
        try (LexicographicallyMaximumSubsequence instance = new LexicographicallyMaximumSubsequence()) {
            instance.solve();
        }
    }
}
