package codeforces.contests701_800.problemset779;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] a = in.next().toCharArray(), b = in.next().toCharArray();
        int n = a.length, m = b.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.ni() - 1;
        }
        int left = 0, right = n - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[] deleted = new boolean[n];
            for (int i = 0; i <= mid; i++) {
                deleted[d[i]] = true;
            }
            int idx = 0;
            for (int i = 0; i < n && idx < m; i++) {
                if (!deleted[i]) {
                    if (a[i] == b[idx]) {
                        idx++;
                    }
                }
            }
            boolean preserve = idx == m;
            if (preserve) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        out.println(result + 1);
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
        try (StringGame instance = new StringGame()) {
            instance.solve();
        }
    }
}
