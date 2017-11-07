package codeforces.contests001_100.problemset041;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MartianDollar implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), b = in.ni(), max = b;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        for (int i = 0; i < n; i++) {
            if (b >= x[i]) {
                int dollars = b / x[i];
                int rem = b % x[i], temp = 0;
                for (int j = i + 1; j < n; j++) {
                    int gain = dollars * x[j];
                    if (rem + gain > temp) {
                        temp = rem + gain;
                    }
                }
                if (temp > max) max = temp;
            }
        }
        out.println(max);
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
        try (MartianDollar instance = new MartianDollar()) {
            instance.solve();
        }
    }
}
