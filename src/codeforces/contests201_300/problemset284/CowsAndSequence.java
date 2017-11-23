package codeforces.contests201_300.problemset284;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowsAndSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        int count = 1;
        long total = 0L;
        long[] values = new long[200002];
        long[] sum = new long[200002];
        while (n-- > 0) {
            int t = in.ni();
            if (t == 1) {
                int a = in.ni();
                long x = in.nl();
                sum[a] += x;
                total += a * x;
            } else if (t == 2) {
                long k = in.nl();
                values[++count] = k;
                total += k;
            } else {
                total -= values[count] + sum[count];
                sum[count - 1] += sum[count];
                sum[count--] = 0;
            }
            out.println((total * 1.0) / count);
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
        try (CowsAndSequence instance = new CowsAndSequence()) {
            instance.solve();
        }
    }
}
