package codeforces.contests1001_1100.problemset1093;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LettersRearranging implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] x = in.next().toCharArray();
            int[] cnt = new int[26];
            for (char c : x) cnt[c - 'a']++;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    for (int j = 0; j < cnt[i]; j++) {
                        result.append((char) ('a' + i));
                    }
                }
            }
            if (result.charAt(0) == result.charAt(result.length() - 1)) {
                out.println(-1);
            } else {
                out.println(result);
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
        try (LettersRearranging instance = new LettersRearranging()) {
            instance.solve();
        }
    }
}
