package codeforces.contests1001_1100.problemset1020;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NewBuildingForSis implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), h = in.ni(), a = in.ni(), b = in.ni(), q = in.ni();
        while (q-- > 0) {
            int ta = in.ni(), fa = in.ni(), tb = in.ni(), fb = in.ni();
            if (ta == tb) {
                out.println(abs(fa - fb));
            } else {
                int f = fa >= b ? b : (fa <= a ? a : fb);
                out.println(abs(ta - tb) + abs(f - fa) + abs(f - fb));
            }
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
        try (NewBuildingForSis instance = new NewBuildingForSis()) {
            instance.solve();
        }
    }
}
