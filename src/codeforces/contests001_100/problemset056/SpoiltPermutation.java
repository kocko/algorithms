package codeforces.contests001_100.problemset056;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpoiltPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) x[i] = in.ni();
        int[] result = {0, 0};
        for (int i = 1; i <= n;) {
            if (x[i] != i) {
                if (result[0] != 0) {
                    result[0] = result[1] = 0;
                    break;
                }
                int num = i;
                boolean ok = true; 
                for (int j = x[i]; j >= i + 1; j--) {
                    ok &= x[j] == num;
                    num++;
                }
                if (ok) {
                    result[0] = Math.min(x[i], i);
                    result[1] = Math.max(x[i], i);
                    i = x[i] + 1;
                } else {
                    result[0] = result[1] = 0;
                    break;
                }
            } else i++;
        }
        out.println(result[0] + " " + result[1]);
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
        try (SpoiltPermutation instance = new SpoiltPermutation()) {
            instance.solve();
        }
    }
}
