package codeforces.contests301_400.problemset315;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SerejaAndArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        long[] lastValue = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            lastValue[i] = in.nl();
        }
        long[] delta = new long[100001];
        int[] lastUpdate = new int[100001];
        for (int i = 1; i <= q; i++) {
            delta[i] = delta[i - 1];
            int type = in.ni();
            if (type == 1) {
                int idx = in.ni();
                long value = in.nl();
                lastValue[idx] = value;
                lastUpdate[idx] = i;
            } else if (type == 2) {
                long d = in.nl();
                delta[i] += d;
            } else {
                int idx = in.ni();
                int time = lastUpdate[idx];
                long ans = lastValue[idx] + (delta[i] - delta[time]);
                out.println(ans);
            }
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
        try (SerejaAndArray instance = new SerejaAndArray()) {
            instance.solve();
        }
    }
}
