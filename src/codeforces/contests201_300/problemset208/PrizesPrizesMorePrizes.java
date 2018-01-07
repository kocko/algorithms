package codeforces.contests201_300.problemset208;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrizesPrizesMorePrizes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] price = new long[6];
        long[] collection = new long[6];
        long[] history = new long[n];
        for (int i = 0; i < n; i++) history[i] = in.ni();
        for (int i = 1; i <= 5; i++) price[i] = in.ni();
        long points = 0L;
        for (int i = 0; i < n; i++) {
            points += history[i];
            for (int j = price.length - 1; j >= 1; j--) {
                if (price[j] <= points) {
                    long count = points / price[j];
                    long rem = points % price[j];
                    collection[j] += count;
                    points = rem;
                }
            }
        }
        for (int i = 1; i <= 5; i++) {
            out.print(collection[i]);
            out.print(' ');
        }
        out.println();
        out.println(points);
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
        try (PrizesPrizesMorePrizes instance = new PrizesPrizesMorePrizes()) {
            instance.solve();
        }
    }
}
