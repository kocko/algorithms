package codeforces.contests701_800.problemset732;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sanatorium implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long[] x = {in.nl(), in.nl(), in.nl()};
        Arrays.sort(x);
        long m = startFromB(x[2], x[1], x[0]);
        out.println(m);
    }
    
    private long startFromB(long b, long d, long s) {
        long max = Math.max(b, Math.max(d, s));
        long result;
        if (s == max) {
            result = s - d + s - b;
        } else if (d == max) {
            long maxS = d - 1;
            if (maxS < s) {
                maxS = s;
            }
            result = d - b + maxS - s;
        } else {
            long maxD = b - 1, maxS = b - 1;
            if (maxS < s) {
                maxD = s;
                maxS = s;
            } else if (maxD < d) {
                maxD = d;
            }
            result = maxD - d + maxS - s;
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
        try (Sanatorium instance = new Sanatorium()) {
            instance.solve();
        }
    }
}
