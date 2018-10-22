package codeforces.contests1001_1100.problemset1066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Heaters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), r = in.ni(), result = n;
        int[] x = new int[n], cover = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                for (int j = max(0, i - r + 1); j <= min(n - 1, i + r - 1); j++) {
                    cover[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (cover[i] == 0) {
                out.println(-1);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            boolean turnOff = true;
            if (x[i] == 1) {
                for (int j = max(0, i - r + 1); j <= min(n - 1, i + r - 1); j++) {
                    if (cover[j] == 1) {
                        turnOff = false;
                    }
                }
                if (turnOff) {
                    result--;
                    for (int j = max(0, i - r + 1); j <= min(n - 1, i + r - 1); j++) {
                        cover[j]--;
                    }
                }
            } else {
                result--;
            }
        }
        out.println(result);
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
        try (Heaters instance = new Heaters()) {
            instance.solve();
        }
    }
}
