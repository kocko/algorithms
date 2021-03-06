package codeforces.contests1001_1100.problemset1005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DeleteFromTheLeft implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int i = x.length - 1, j = y.length - 1;
        while (i >= 0 || j >= 0) {
            char a = i >= 0 ? x[i] : '?';
            char b = j >= 0 ? y[j] : '!';
            if (a != b) break;
            i--; j--;
        }
        int result = 0;
        if (i >= 0) result += i + 1;
        if (j >= 0) result += j + 1;
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
        try (DeleteFromTheLeft instance = new DeleteFromTheLeft()) {
            instance.solve();
        }
    }
}
