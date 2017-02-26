package codeforces.contests701_800.problemset779;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PupilsRedistribution implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] x = new int[6];
        int[] y = new int[6];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            x[a[i]]++;
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.ni();
            y[b[i]]++;
        }
        int result = 0;
        for (int i = 1; i <= 5; i++) {
            int total = x[i] + y[i];
            if (total % 2 == 1) {
                out.println(-1);
                return;
            }
            int half = total / 2;
            result += Math.abs(x[i] - half);
        }
        out.println(result / 2);
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
        try (PupilsRedistribution instance = new PupilsRedistribution()) {
            instance.solve();
        }
    }
}
