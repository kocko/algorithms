package codeforces.contests1001_1100.problemset1095;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlmostRegularBracketSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int[] left = new int[n];
        boolean[] canLeft = new boolean[n];
        for (int i = 0; i < n; i++) {
            int addition = x[i] == '(' ? 1 : -1;
            left[i] = addition + (i > 0 ? left[i - 1] : 0);
            if (i == 0) {
                canLeft[0] = left[i] == 1;
            } else {
                canLeft[i] = canLeft[i - 1] && left[i] >= 0;
            }
        }
        int[] right = new int[n];
        boolean[] canRight = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            int addition = x[i] == ')' ? 1 : -1;
            right[i] = addition + (i < n - 1 ? right[i + 1] : 0);
            if (i == n - 1) {
                canRight[n - 1] = right[i] == 1;
            } else {
                canRight[i] = canRight[i + 1] && right[i] >= 0;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (x[i] == ')') {
                    if (i + 1 < n && canRight[i + 1] && right[i + 1] == 1) result++;
                }
            } else if (i == n - 1) {
                if (x[i] == '(') {
                    if (i - 1 >= 0 && canLeft[i - 1] && left[i - 1] == 1) result++;
                }
            } else {
                if (x[i] == '(') {
                    if (canLeft[i - 1] && canRight[i + 1] && left[i - 1] - 1 == right[i + 1]) result++;
                } else {
                    if (canLeft[i - 1] && canRight[i + 1] && left[i - 1] + 1 == right[i + 1]) result++;
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
        try (AlmostRegularBracketSequence instance = new AlmostRegularBracketSequence()) {
            instance.solve();
        }
    }
}
