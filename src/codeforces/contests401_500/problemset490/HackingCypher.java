package codeforces.contests401_500.problemset490;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HackingCypher implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int a = in.ni(), b = in.ni(), n = x.length;
        int[] prefix = new int[n], suffix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = (x[i] - '0') % a;
            } else {
                prefix[i] = (prefix[i - 1] * 10 + (x[i] - '0')) % a;
            }
        }
        int p = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                suffix[i] = (x[i] - '0') % b;
            } else {
                suffix[i] = (suffix[i + 1] + ((x[i] - '0') * p)) % b;
            }
            p *= 10;
            p %= b;
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == 0 && suffix[i + 1] == 0 && x[i + 1] != '0') {
                out.println("YES");
                for (int j = 0; j <= i; j++) {
                    out.print(x[j]);
                }
                out.println();
                for (int j = i + 1; j < n; j++) {
                    out.print(x[j]);
                }
                return;
            }
        }
        out.println("NO");
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
        try (HackingCypher instance = new HackingCypher()) {
            instance.solve();
        }
    }
}
