package codeforces.contests1001_1100.problemset1016;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SegmentOccurrences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), q = in.ni();
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int[] after = new int[n + 1];
        for (int begin = n - m; begin >= 0; begin--) {
            boolean ok = true;
            for (int i = begin, j = 0; i < begin + m; i++, j++) {
                ok &= x[i] == y[j];
            }
            after[begin] = after[begin + 1];
            if (ok) {
                after[begin] = after[begin + 1] + 1;
            } 
        }
        while (q-- > 0) {
            int left = in.ni() - 1, right = in.ni() - 1;
            if (right - left + 1 < m) {
                out.println(0);
            } else {
                out.println(after[left] - after[right - m + 2]);
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

    public static void main(String[] args) throws IOException {
        try (SegmentOccurrences instance = new SegmentOccurrences()) {
            instance.solve();
        }
    }
}
