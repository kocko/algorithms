package codeforces.contests601_700.problemset660;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HardProcess implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int left = 0, right = -1;
        int maxLeft = -1, maxRight = -1;
        int max = 0;
        int zeroes = 0;
        while (left < n) {
            while (right < n - 1 && (zeroes < k || x[right + 1] == 1)) {
                right++;
                if (x[right] == 0) {
                    zeroes++;
                }
            }
            if (left <= right && right - left + 1 > max) {
                max = right - left + 1;
                maxRight = right;
                maxLeft = left;
            }
            left++;
            if (x[left - 1] == 0) zeroes--;
        }

        out.println(max);
        for (int i = 0; i < n; i++) {
            if (i >= maxLeft && i <= maxRight) {
                out.print(1 + " ");
            } else {
                out.print(x[i] + " ");
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
        try (HardProcess instance = new HardProcess()) {
            instance.solve();
        }
    }
}
