package codeforces.contests401_500.problemset463;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GargariAndBishops implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[][] x = new long[n][n];
        long[] diagonal = new long[n << 1 | 1];
        long[] reversed = new long[n << 1 | 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = in.nl();
                diagonal[i + j] += x[i][j];
                reversed[j - i + n - 1] += x[i][j];
            }
        }
        int[] odd = {1, 2}, even = {1, 1};
        long maxOdd = 0, maxEven = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long value = x[i][j], profit = diagonal[i + j] + reversed[j - i + n - 1] - value;
                if ((i + j) % 2 == 0) {
                    if (profit > maxEven) {
                        maxEven = profit;
                        even = new int[]{i + 1, j + 1};
                    }
                } else {
                    if (profit > maxOdd) {
                        maxOdd = profit;
                        odd = new int[]{i + 1, j + 1};
                    }
                }
            }
        }
        out.println(maxEven + maxOdd);
        out.println(odd[0] + " " + odd[1] + " " + even[0] + " " + even[1]);
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
        try (GargariAndBishops instance = new GargariAndBishops()) {
            instance.solve();
        }
    }
}
