package codeforces.contests401_500.problemset433;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class KuriyamaMiraisStones implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] stones = new long[n];
        List<Long> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stones[i] = in.ni();
            sorted.add(stones[i]);
        }
        Collections.sort(sorted);
        long[] prefix = new long[n];
        long[] sortedPrefix = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = stones[i];
                sortedPrefix[i] = sorted.get(i);
            } else {
                prefix[i] = prefix[i - 1] + stones[i];
                sortedPrefix[i] = sortedPrefix[i - 1] + sorted.get(i);
            }
        }
        int q = in.ni();
        while (q-- > 0) {
            int type = in.ni(), left = in.ni() - 1, right = in.ni() - 1;
            long[] arr = type == 1 ? prefix : sortedPrefix;
            long ans = arr[right];
            if (left >= 1) ans -= arr[left - 1];
            out.println(ans);
        }
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
        try (KuriyamaMiraisStones instance = new KuriyamaMiraisStones()) {
            instance.solve();
        }
    }
}
