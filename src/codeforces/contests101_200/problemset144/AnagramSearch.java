package codeforces.contests101_200.problemset144;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnagramSearch implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray(), p = in.next().toCharArray();
        int[] cnt = new int[26];
        for (char c : p) {
            cnt[c - 'a']++;
        }
        int result = 0, size = p.length;
        int[] mask = new int[26];
        for (int i = 0; i < s.length; i++) {
            if (i >= size) {
                char c = s[i - size];
                if (c >= 'a' && c <= 'z') {
                    mask[c - 'a']--;
                }
            }
            if (s[i] >= 'a' && s[i] <= 'z') {
                mask[s[i] - 'a']++;
            }
            if (i >= size - 1) {
                if (compatible(cnt, mask)) {
                    result++;
                }
            }
        }
        out.println(result);
    }

    private boolean compatible(int[] a, int[] b) {
        boolean result = true;
        for (int i = 0; i < 26; i++) {
            result &= (a[i] - b[i] >= 0);
        }
        return result;
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
        try (AnagramSearch instance = new AnagramSearch()) {
            instance.solve();
        }
    }
}
