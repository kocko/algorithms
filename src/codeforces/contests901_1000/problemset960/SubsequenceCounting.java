package codeforces.contests901_1000.problemset960;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SubsequenceCounting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long x = in.nl(), d = in.nl();
        List<Long> result = new ArrayList<>();
        long idx = 1;
        while (x > 0) {
            long n = 0, i = 0;
            while ((1L << i) - 1 <= x) {
                n = i++;
            }
            for (long j = idx; j < idx + n; j++) {
                result.add(idx);
            }
            idx += n + d + 1;
            x -= ((1L << n) - 1);
        }
        out.println(result.size());
        for (Long value : result) {
            out.print(value);
            out.print(' ');
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
        try (SubsequenceCounting instance = new SubsequenceCounting()) {
            instance.solve();
        }
    }
}
