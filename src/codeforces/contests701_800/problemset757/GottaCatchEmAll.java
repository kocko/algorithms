package codeforces.contests701_800.problemset757;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GottaCatchEmAll implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int[] up = new int[26];
        int[] low = new int[26];
        for (char c : x) {
            if (c >= 'A' && c <= 'Z') up[c - 'A']++;
            if (c >= 'a' && c <= 'z') low[c - 'a']++;
        }
        int result = up['B' - 'A'];
        result = Math.min(low['u' - 'a'] / 2, result);
        result = Math.min(low['l' - 'a'], result);
        result = Math.min(low['b' - 'a'], result);
        result = Math.min(low[0] / 2, result);
        result = Math.min(low['s' - 'a'], result);
        result = Math.min(low['r' - 'a'], result);
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
        try (GottaCatchEmAll instance = new GottaCatchEmAll()) {
            instance.solve();
        }
    }
}
