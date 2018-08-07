package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.String.valueOf;
import static java.util.Arrays.sort;

public class SubstringSorter implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), l = in.ni();
        char[] x = in.next().toCharArray();
        String best = valueOf(x);
        for (int i = 0; i <= n - l; i++) {
            char[] cp = new char[l];
            System.arraycopy(x, i, cp, 0, l);
            sort(cp);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(x[j]);
            }
            for (int j = 0; j < l; j++) {
                sb.append(cp[j]);
            }
            for (int j = i + l; j < n; j++) {
                sb.append(x[j]);
            }
            if (sb.toString().compareTo(best) < 0) {
                best = sb.toString();
            }
        }
        out.println(best);
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
        try (SubstringSorter instance = new SubstringSorter()) {
            instance.solve();
        }
    }
}
