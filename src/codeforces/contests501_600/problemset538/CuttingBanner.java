package codeforces.contests501_600.problemset538;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CuttingBanner implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] codeforces = "CODEFORCES".toCharArray();
        char[] word = in.next().toCharArray();
        int idx = 0, i = 0, j = 0, n = word.length;
        while (idx < Math.min(10, n)) {
            if (word[idx] == codeforces[j]) {
                j++;
            } else break;
            idx++;
        }
        idx = 0;
        while (idx < Math.min(10, n)) {
            if (word[word.length - idx - 1] == codeforces[9 - i]) {
                i++;
            } else break;
            idx++;
        }
        
        out.println((i + j >= 10) ? "YES" : "NO");
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
        try (CuttingBanner instance = new CuttingBanner()) {
            instance.solve();
        }
    }
}
