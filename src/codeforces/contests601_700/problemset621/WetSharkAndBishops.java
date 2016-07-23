package codeforces.contests601_700.problemset621;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WetSharkAndBishops implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        long[] diag = new long[2001];
        long[] rev = new long[2001];
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            diag[x + y]++;
            rev[1000 + x - y]++;
        }
        long result = 0l;
        for (int i = 2; i < diag.length; i++) {
            if (diag[i] > 1) {
                result += diag[i] * (diag[i] - 1) / 2;
            }
            if (rev[i] > 1) {
                result += rev[i] * (rev[i] - 1) / 2;
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
        new WetSharkAndBishops().solve();
    }
}
