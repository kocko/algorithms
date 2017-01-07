package codeforces.contests501_600.problemset560;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GeraldIsIntoArt implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a1 = in.ni(), b1 = in.ni();
        int a2 = in.ni(), b2 = in.ni();
        int a3 = in.ni(), b3 = in.ni();
        boolean ok = false;
        if (a2 + a3 <= a1 && Math.max(b2, b3) <= b1) ok = true;
        else if (a2 + a3 <= b1 && Math.max(b2, b3) <= a1) ok = true;
        else if (b2 + a3 <= a1 && Math.max(a2, b3) <= b1) ok = true;
        else if (b2 + a3 <= b1 && Math.max(a2, b3) <= a1) ok = true;
        else if (a2 + b3 <= a1 && Math.max(a3, b2) <= b1) ok = true;
        else if (a2 + b3 <= b1 && Math.max(a3, b2) <= a1) ok = true;
        else if (b2 + b3 <= a1 && Math.max(a2, a3) <= b1) ok = true;
        else if (b2 + b3 <= b1 && Math.max(a2, a3) <= a1) ok = true;
        out.println(ok ? "YES" : "NO");
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
        try (GeraldIsIntoArt instance = new GeraldIsIntoArt()) {
            instance.solve();
        }
    }
}
