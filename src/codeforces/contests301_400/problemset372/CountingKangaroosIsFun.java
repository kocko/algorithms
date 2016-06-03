package codeforces.contests301_400.problemset372;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingKangaroosIsFun implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = in.ni();
        }
        Arrays.sort(k);
        int left = 0, right = n / 2 + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            boolean ok = true;
            for (int i = 0; i < mid; i++) {
                if (k[i] * 2 > k[n - mid + i]) ok = false;
            }
            if (ok) left = mid;
            else right = mid;
        }
        out.println(n - left);
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
        new CountingKangaroosIsFun().solve();
    }
}
