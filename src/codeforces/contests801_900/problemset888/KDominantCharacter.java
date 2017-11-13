package codeforces.contests801_900.problemset888;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class KDominantCharacter implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int result = n;
        for (char c = 'a'; c <= 'z'; c++) {
            int last = -1, max = -1;
            for (int i = 0; i < n; i++) {
                if (x[i] == c) {
                    max = max(i - last, max);
                    last = i;
                }
            }
            if (last != -1) {
                max = max(n - last, max);
                result = min(result, max);
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
        try (KDominantCharacter instance = new KDominantCharacter()) {
            instance.solve();
        }
    }
}
