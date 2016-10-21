package codeforces.contests701_800.problemset731;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NightAtTheMuseum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[][] min = new int[26][26];
        for (char c = 'a'; c <= 'z'; c++) {
            for (char x = c; x <= 'z'; x++) {
                min[c - 'a'][x - 'a'] = min[x - 'a'][c - 'a'] = Math.min(x - c, 'z' - x + c - 'a' + 1);
            }
        }
        char[] x = in.next().toCharArray();
        int result = 0;
        char start = 'a';
        for (char c : x) {
            result += min[start - 'a'][c - 'a'];
            start = c;
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
        try (NightAtTheMuseum instance = new NightAtTheMuseum()) {
            instance.solve();
        }
    }
}
