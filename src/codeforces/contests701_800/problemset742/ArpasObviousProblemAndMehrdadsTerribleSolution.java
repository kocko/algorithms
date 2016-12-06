package codeforces.contests701_800.problemset742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArpasObviousProblemAndMehrdadsTerribleSolution implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        long[] has = new long[100001];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            has[next]++;
        }
        long count = 0L;
        for (int i = 1; i < has.length; i++) {
            long a = has[i];
            if (a > 0) {
                int b = i ^ x;
                if (b == i) {
                    count += (a * (a - 1));
                } else {
                    if (b < has.length) {
                        long m = has[b];
                        count += (m * a);
                    }
                }
            }
        }
        out.println(count >> 1);
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
        try (ArpasObviousProblemAndMehrdadsTerribleSolution instance = new ArpasObviousProblemAndMehrdadsTerribleSolution()) {
            instance.solve();
        }
    }
}
