package codeforces.contests401_500.problemset408;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Garland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int[] has = new int[26], need = new int[26];
        for (char c : x) has[c - 'a']++;
        for (char c : y) need[c - 'a']++;
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) {
                if (has[i] > 0) result += Math.min(need[i], has[i]);
                else {
                    result = -1;
                    break;
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
        try (Garland instance = new Garland()) {
            instance.solve();
        }
    }
}
