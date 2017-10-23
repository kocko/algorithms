package codeforces.contests801_900.problemset877;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NikitaAndString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int[] a = new int[n + 1], b = new int[n + 1];
        if (x[0] == 'a') a[1] = 1;
        else b[1] = 1;
        for (int i = 1; i < n; i++) {
            if (x[i] == 'a') {
                a[i + 1] = a[i] + 1;
                b[i + 1] = b[i];
            } else {
                b[i + 1] = b[i] + 1;
                a[i + 1] = a[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int temp = b[i];
                temp += a[j] - a[i];
                temp += b[n] - b[j];
                min = Math.min(temp, min);
            }
        }
        out.println(n - min);
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
        try (NikitaAndString instance = new NikitaAndString()) {
            instance.solve();
        }
    }
}
