package codeforces.contests501_600.problemset525;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PashaAndString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length, k = in.ni();
        int size = n / 2 + (n & 1);
        int[] count = new int[size];
        for (int i = 0; i < k; i++) {
            int next = in.ni() - 1;
            count[next]++;
        }
        int[] prefix = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) prefix[i] = count[i];
            else prefix[i] = prefix[i - 1] + count[i];
        }
        char[] result = new char[n];
        for (int i = 0; i < size; i++) {
            int swap = prefix[i] & 1;
            if (swap == 1) {
                result[i] = x[n - i - 1];
                result[n - i - 1] = x[i];
            } else {
                result[i] = x[i];
                result[n - i - 1] = x[n - i - 1];
            }
        }
        for (char c : result) out.print(c);
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
        try (PashaAndString instance = new PashaAndString()) {
            instance.solve();
        }
    }
}
