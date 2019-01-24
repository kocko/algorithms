package codeforces.contests1101_1200.problemset1108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NiceGarland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        String[] p = {"RGB", "RBG", "BRG", "BGR", "GRB", "GBR"};
        int min = n + 1;
        String best = "";
        for (String perm : p) {
            int changes = 0;
            for (int i = 0; i < n; i++) {
                if (perm.charAt(i % 3) != x[i]) changes++;
            }
            if (changes < min) {
                min = changes;
                best = perm;
            }
        }
        out.println(min);
        for (int i = 0; i < n; i++) {
            out.print(best.charAt(i % 3));
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
        try (NiceGarland instance = new NiceGarland()) {
            instance.solve();
        }
    }
}
