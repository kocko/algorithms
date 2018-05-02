package codeforces.contests901_1000.problemset975;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Mancala implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long[] x = new long[14];
        for (int i = 0; i < 14; i++) {
            x[i] = in.nl();
        }
        long max = 0;
        for (int i = 0; i < 14; i++) {
            long[] copy = new long[14];
            System.arraycopy(x, 0, copy, 0, 14);
            if (x[i] > 0) {
                max = max(max, test(copy, i));
            }
        }
        out.println(max);
    }
    
    private long test(long[] x, int idx) {
        long result = 0;
        long count = x[idx];
        x[idx] = 0;
        for (int i = idx + 1; i < 14; i++) {
            if (count == 0) break;
            x[i]++;
            count--;
        }
        long batch = count / 14, rem = count % 14;
        for (int i = 0; i < 14; i++) {
            x[i] += batch;
        }
        for (int i = 0; i < 14; i++) {
            if (rem == 0) break;
            x[i]++;
            rem--;
        }
        for (int i = 0; i < 14; i++) {
            if (x[i] % 2 == 0) result += x[i];
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
        try (Mancala instance = new Mancala()) {
            instance.solve();
        }
    }
}
