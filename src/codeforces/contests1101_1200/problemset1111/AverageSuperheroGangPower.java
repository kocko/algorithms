package codeforces.contests1101_1200.problemset1111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.reverseOrder;

public class AverageSuperheroGangPower implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long k = in.nl(), m = in.nl();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nl());
        }
        list.sort(reverseOrder());
        long[] prefix = new long[n + 1];
        prefix[0] = list.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + list.get(i);
        }
        double result = 0;
        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;

            long remaining = m - needed;
            if (remaining < 0) continue;

            long multiplier = Math.min(remaining, k * (i + 1));
            double current = (prefix[i] + multiplier) / (i + 1.);
            result = Math.max(result, current);
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
        try (AverageSuperheroGangPower instance = new AverageSuperheroGangPower()) {
            instance.solve();
        }
    }
}
