package codeforces.contests1001_1100.problemset1087;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RightLeftCipher implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        StringBuilder result = new StringBuilder();
        int start = x.length / 2;
        if (x.length % 2 == 0) {
            start--;
        }
        result.append(x[start]);
        int left = start - 1, right = start + 1;
        boolean isLeft = false;
        for (int i = 1; i < x.length; i++) {
            if (isLeft) {
                result.append(x[left--]);
            } else {
                result.append(x[right++]);
            }
            isLeft = !isLeft;
        }
        out.println(result.toString());
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
        try (RightLeftCipher instance = new RightLeftCipher()) {
            instance.solve();
        }
    }
}
