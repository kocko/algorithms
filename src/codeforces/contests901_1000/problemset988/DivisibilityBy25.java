package codeforces.contests901_1000.problemset988;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class DivisibilityBy25 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        s = in.next();
        n = s.length();
        if (n == 1) {
            out.println(-1);
            return;
        }
        int result = go('0', '0');
        result = min(result, go('2', '5'));
        result = min(result, go('5', '0'));
        result = min(result, go('7', '5'));
        out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private String s;
    private int n;

    private int go(char a, char b) {
        char[] x = s.toCharArray();
        int swaps = 0;
        int idx = n - 1;
        for (char c : new char[]{b, a}) {
            boolean found = false;
            for (int i = idx; i >= 0; i--) {
                if (x[i] == c) {
                    for (int j = i; j < idx; j++) {
                        char temp = x[j];
                        x[j] = x[j + 1];
                        x[j + 1] = temp;
                        swaps++;
                    }
                    found = true;
                    idx--;
                    break;
                }
            }
            if (!found) return Integer.MAX_VALUE;
        }
        if (x[0] == '0') {
            for (int i = 1; i < n; i++) {
                if (x[i] != '0') {
                    swaps += i;
                    x[0] = x[i];
                    x[i] = '0';
                    break;
                }
            }
        }
        if (x[n - 2] == a && x[n - 1] == b) return swaps;
        return Integer.MAX_VALUE;
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
        try (DivisibilityBy25 instance = new DivisibilityBy25()) {
            instance.solve();
        }
    }
}
