package codeforces.contests601_700.problemset686;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleRobberGirlsZoo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (x[j] < x[j - 1]) {
                    out.println(j + " " + (j + 1));
                    int t = x[j];
                    x[j] = x[j - 1];
                    x[j - 1] = t;
                }
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
        try (LittleRobberGirlsZoo instance = new LittleRobberGirlsZoo()) {
            instance.solve();
        }
    }
}
