package codeforces.contests501_600.problemset550;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.toBinaryString;

public class PreparingOlympiad implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), l = in.ni(), r = in.ni(), x = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int limit = (1 << n);
        int result = 0;
        for (int i = 1; i <= limit; i++) {
            if (bitCount(i) > 1) {
                String binary = String.format("%" + n + "s", toBinaryString(i)).replace(' ', '0');
                int total = 0, min = 1000005, max = 0;
                for (int j = 0; j < binary.length(); j++) {
                    char c = binary.charAt(j);
                    if (c == '1') {
                        total += a[j];
                        if (a[j] > max) max = a[j];
                        if (a[j] < min) min = a[j];
                    }
                }
                if (total >= l && total <= r && (max - min) >= x) {
                    result++;
                }
            }
        }
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
        try (PreparingOlympiad instance = new PreparingOlympiad()) {
            instance.solve();
        }
    }
}
