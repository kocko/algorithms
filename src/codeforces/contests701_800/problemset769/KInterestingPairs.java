package codeforces.contests701_800.problemset769;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KInterestingPairs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] > max) max = x[i];
        }
        long[] count = new long[max + 1];
        for (int i : x) {
            count[i]++;
        }
        long result = 0;
        for (int i = 0; i <= max; i++) {
            if (count[i] > 0) {
                for (int j = i; j <= max; j++) {
                    if (count[j] > 0) {
                        if (Integer.bitCount(i ^ j) == k) {
                            if (i == j) {
                                result += (count[i] * (count[i] - 1)) / 2;
                            } else {
                                result += (count[i] * count[j]);
                            }
                        }
                    }
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
        try (KInterestingPairs instance = new KInterestingPairs()) {
            instance.solve();
        }
    }
}
