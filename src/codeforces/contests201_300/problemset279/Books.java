package codeforces.contests201_300.problemset279;

import java.io.*;
import java.util.StringTokenizer;

public class Books implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), t = in.ni();
        int[] prefix = new int[n + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = in.ni() + prefix[i - 1];
            if (prefix[i] <= t) {
                result = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (prefix[i] > t) {
                int threshold = prefix[i] - t;
                int m = binary(prefix, threshold);
                result = Math.max(result, i - m);
            }
        }
        out.println(result);
    }

    int binary(int[] prefix, int threshold) {
        int left = 0, right = prefix.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (prefix[middle] >= threshold) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
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
        new Books().solve();
    }
}
