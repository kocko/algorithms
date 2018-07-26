package codeforces.contests501_600.problemset525;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class AnyaAndCubes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        k = in.ni();
        s = in.nl();
        half = n / 2;
        x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        left();
        right();
        out.println(result);
    }

    private int n, k, half;
    private long s, result;
    private long[] x;

    private long[] fact = new long[19];

    {
        fact[1] = 1L;
        for (int i = 2; i < 19; i++) fact[i] = fact[i - 1] * i;
    }

    private Map<Integer, Map<Long, Long>> map = new HashMap<>();

    private void left() {
        int limit = (int) pow(3, half) - 1;
        for (int value = 0; value <= limit; value++) {
            int[] mask = ternary(value, half);
            long total = 0;
            int factorials = 0;
            for (int i = 0; i < half; i++) {
                long elem = x[i];
                if (mask[i] == 2) {
                    factorials++;
                    if (elem >= 19) {
                        total = -1;
                        break;
                    } else {
                        total += fact[(int) elem];
                    }
                } else if (mask[i] == 1) {
                    total += elem;
                }
            }
            if (total != -1) {
                Map<Long, Long> sums = map.getOrDefault(factorials, new HashMap<>());
                sums.put(total, sums.getOrDefault(total, 0L) + 1);
                map.put(factorials, sums);
            }
        }
    }

    private void right() {
        int limit = (int) pow(3, n - half) - 1;
        for (int value = 0; value <= limit; value++) {
            int[] mask = ternary(value, n - half);
            long total = 0;
            int factorials = 0;
            for (int i = 0; i < mask.length; i++) {
                long elem = x[half + i];
                if (mask[i] == 2) {
                    factorials++;
                    if (elem >= 19) {
                        total = -1;
                        break;
                    } else {
                        total += fact[(int) elem];
                    }
                } else if (mask[i] == 1) {
                    total += elem;
                }
            }
            if (total != -1) {
                for (Map.Entry<Integer, Map<Long, Long>> entry : map.entrySet()) {
                    if (entry.getKey() + factorials <= k) {
                        Map<Long, Long> sums = entry.getValue();
                        result += sums.getOrDefault(s - total, 0L);
                    }
                }
            }
        }
    }

    private int[] ternary(int x, int size) {
        int[] result = new int[size];
        int idx = size - 1;
        while (x > 0) {
            result[idx--] = x % 3;
            x /= 3;
        }
        return result;
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
        try (AnyaAndCubes instance = new AnyaAndCubes()) {
            instance.solve();
        }
    }
}
