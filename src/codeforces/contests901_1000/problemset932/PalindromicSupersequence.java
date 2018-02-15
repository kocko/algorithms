package codeforces.contests901_1000.problemset932;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromicSupersequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int[] count = new int[26];
        for (char c : x) {
            count[c - 'a']++;
        }
        StringBuilder front = new StringBuilder(), back = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int times = count[i];
            if (times % 2 == 1) times++;
            for (int j = 0; j < times / 2; j++) {
                front.append((char) ('a' + i));
                back.append((char) ('a' + i));
            }
        }
        out.println(front.append(back.reverse()).toString());
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
        try (PalindromicSupersequence instance = new PalindromicSupersequence()) {
            instance.solve();
        }
    }
}
