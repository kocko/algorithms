package codeforces.contests001_100.problemset067;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PartialTeacher implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] result = new int[n];
        char[] a = in.next().toCharArray();
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == '=') {
                result[i] = result[i - 1];
            } else if (a[i - 1] == 'R') {
                result[i] = result[i - 1] + 1;
            } else if (a[i - 1] == 'L') {
                result[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] == '=') {
                result[i] = result[i + 1];
            } else if (a[i] == 'L') {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            if (i == n - 1) {
                out.println();
            } else {
                out.print(" ");
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

    public static void main(String[] args) {
        new PartialTeacher().solve();
    }
}
