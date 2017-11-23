package codeforces.contests201_300.problemset231;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ToAddOrNotToAdd implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long k = in.nl();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) x[i] = in.nl();
        Arrays.sort(x);
        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = x[i];
            if (i > 0) prefix[i] += prefix[i - 1];
        }
        long maxCount = 1, minNumber = x[n - 1];
        for (int i = 1; i < n; i++) {
            int left = 0, right = i - 1;
            long max = 0, number = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long size = i - mid;
                
                long sum = prefix[i - 1];
                if (mid > 0) sum -= prefix[mid - 1];
                
                long diff = size * x[i] - sum;
                
                if (diff <= k) {
                    right = mid - 1;
                    if (size > max) {
                        max = size;
                        number = x[i];
                    } else if (size == max) {
                        number = Math.min(number, x[i]);
                    }
                } else {
                    left = mid + 1;
                }
            }
            if (max + 1 > maxCount) {
                maxCount = max + 1;
                minNumber = number;
            } else if (max + 1 == maxCount) {
                minNumber = Math.min(minNumber, number);
            }
        }
        out.println(maxCount + " " + minNumber);
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
        try (ToAddOrNotToAdd instance = new ToAddOrNotToAdd()) {
            instance.solve();
        }
    }
}
