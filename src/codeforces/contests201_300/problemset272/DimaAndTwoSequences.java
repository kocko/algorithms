package codeforces.contests201_300.problemset272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DimaAndTwoSequences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            int count = map.getOrDefault(a[i], 0) + 1;
            map.put(a[i], count);
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.ni();
            int count = map.getOrDefault(b[i], 0) + 1;
            map.put(b[i], count);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) count++;
        }
        long result = 1;
        final int MOD = in.ni();
        for (int p : map.values()) {
            for (int i = 2; i <= p; i++) {
                int num = i;
                if (num % 2 == 0 && count > 0) {
                    num /= 2;
                    count--;
                }
                result *= num;
                result %= MOD;
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
        try (DimaAndTwoSequences instance = new DimaAndTwoSequences()) {
            instance.solve();
        }
    }
}
