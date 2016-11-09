package codeforces.contests301_400.problemset313;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IlyaAndQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        int[] dots = new int[n];
        dots[0] = x[0] == '.' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dots[i] = dots[i - 1] + ((x[i] == x[i - 1] && x[i - 1] == '.') ? 1 : 0);
        }
        int[] dashes = new int[n];
        dashes[0] = x[0] == '#' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dashes[i] = dashes[i - 1] + ((x[i] == x[i - 1] && x[i - 1] == '#') ? 1 : 0);
        }
        int q = in.ni();
        while (q-- > 0) {
            int left = in.ni(), right = in.ni();
            out.println(dots[right - 1] - dots[left - 1] + dashes[right - 1] - dashes[left - 1]);
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
        try (IlyaAndQueries instance = new IlyaAndQueries()) {
            instance.solve();
        }
    }
}
