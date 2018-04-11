package codeforces.contests501_600.problemset540;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SchoolMarks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), p = in.ni(), x = in.ni(), y = in.ni();
        int[] has = new int[k];
        int sum = 0, less = 0;
        for (int i = 0; i < k; i++) {
            has[i] = in.ni();
            sum += has[i];
            if (has[i] < y) {
                less++;
            }
        }
        int idx = 0;
        int[] result = new int[n - k];
        if (less > n / 2) {
            out.println(-1);
            return;
        }
        while (idx < n - k && less < n / 2) {
            result[idx++] = 1;
            sum++;
            less++;
        }
        int min = Math.min(y, p);
        while (idx < n - k) {
            result[idx++] = min;
            sum += min;
        }
        if (sum > x) {
            out.println(-1);
        } else {
            for (int i : result) {
                out.print(i);
                out.print(' ');
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
        try (SchoolMarks instance = new SchoolMarks()) {
            instance.solve();
        }
    }
}
