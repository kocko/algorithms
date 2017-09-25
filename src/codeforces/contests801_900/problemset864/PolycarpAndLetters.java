package codeforces.contests801_900.problemset864;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PolycarpAndLetters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int result = 0;
        boolean[] has = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (x[i] >= 'a' && x[i] <= 'z') {
                has[x[i] - 'a'] = true;
            } else {
                int cnt = 0;
                for (int j = 0; j < 26; j++) {
                    if (has[j]) {
                        cnt++;
                    }
                }
                result = Math.max(cnt, result);
                has = new boolean[26];
            }
        }
        int cnt = 0;
        for (int j = 0; j < 26; j++) {
            if (has[j]) {
                cnt++;
            }
        }
        result = Math.max(cnt, result);
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
        try (PolycarpAndLetters instance = new PolycarpAndLetters()) {
            instance.solve();
        }
    }
}
