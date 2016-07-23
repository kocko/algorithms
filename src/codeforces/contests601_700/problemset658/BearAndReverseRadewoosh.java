package codeforces.contests601_700.problemset658;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndReverseRadewoosh implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), c = in.ni();
        int[] p = new int[n], t = new int[n];
        long limak = 0, radewoosh = 0;
        for (int i = 0; i < n; i++) {
            p[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            t[i] = in.ni();
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            limak += Math.max(0, p[i] - c * (total + t[i]));
            total += t[i];
        }
        total = 0;
        for (int i = n - 1; i >= 0; i--) {
            radewoosh += Math.max(0, p[i] - c * (total + t[i]));
            total += t[i];
        }
        if (limak == radewoosh) {
            out.println("Tie");
        } else {
            out.println(limak > radewoosh ? "Limak" : "Radewoosh");
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

    public static void main(String[] args) {
        new BearAndReverseRadewoosh().solve();
    }
}
