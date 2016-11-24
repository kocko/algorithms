package codeforces.contests401_500.problemset459;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PashmakAndFlowers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int min = Integer.MAX_VALUE, max = 0;
        List<Integer> f = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            f.add(next);
            min = Math.min(next, min);
            max = Math.max(next, max);
        }
        Collections.sort(f);
        if (max != min) {
            int diff = f.get(n - 1) - f.get(0);
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                int next = f.get(i);
                if (next == max) a++;
                else if (next == min) b++;
            }
            long k = ((long) a) * b;
            out.println(diff + " " + k);
        } else {
            int a = 0;
            for (int i = 0; i < n; i++) {
                int next = f.get(i);
                if (next == max) a++;
            }
            long k = (((long)a) * (a - 1))/ 2L;
            out.println(0 + " " + k);
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
        try (PashmakAndFlowers instance = new PashmakAndFlowers()) {
            instance.solve();
        }
    }
}
