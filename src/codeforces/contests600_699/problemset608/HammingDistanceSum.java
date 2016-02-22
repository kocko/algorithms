package codeforces.contests600_699.problemset608;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HammingDistanceSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        char[] a = in.next().toCharArray(); int n = a.length;
        char[] b = in.next().toCharArray(); int m = b.length;

        int[] prefix = new int[b.length + 1];
        prefix[0] = b[0] - '0';
        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] + (b[i] - '0');
        }

        long result = 0L;
        for (int i = 0; i < n; i++) {
            if (a[i] == '0') {
                result += prefix[m - n + i] - prefix[i];
            } else {
                result += m - n + 1 - (prefix[m - n + i] - prefix[i]);
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

    public static void main(String[] args) {
        new HammingDistanceSum().solve();
    }
}
