package codeforces.contests301_400.problemset367;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.util.Arrays.sort;

public class SerejaAndAlgorithm implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray();
        int n = s.length;
        int[] x = new int[n + 1], y = new int[n + 1], z = new int[n + 1];
        x[1] = s[0] == 'x' ? 1 : 0;
        y[1] = s[0] == 'y' ? 1 : 0;
        z[1] = s[0] == 'z' ? 1 : 0;
        for (int i = 1; i < n; i++) x[i + 1] = x[i] + (s[i] == 'x' ? 1 : 0);
        for (int i = 1; i < n; i++) y[i + 1] = y[i] + (s[i] == 'y' ? 1 : 0);
        for (int i = 1; i < n; i++) z[i + 1] = z[i] + (s[i] == 'z' ? 1 : 0);
        int q = in.ni();
        while (q-- > 0) {
            int left = in.ni(), right = in.ni(), size = right - left + 1;
            boolean terminate = true;
            if (size >= 3) {
                int xs = x[right] - x[left - 1], ys = y[right] - y[left - 1], zs = z[right] - z[left - 1];
                terminate = terminate(xs, ys, zs);
            }
            out.println(terminate ? "YES" : "NO");
        }
    }
    
    private boolean terminate(int x, int y, int z) {
        int hi = max(x, max(y, z));
        int lo = min(x, min(y, z));
        return hi - lo <= 1;
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
        try (SerejaAndAlgorithm instance = new SerejaAndAlgorithm()) {
            instance.solve();
        }
    }
}
