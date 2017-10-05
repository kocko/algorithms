package codeforces.contests801_900.problemset868;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BarkToUnlock implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        int n = in.ni();
        String[] a = new String[n];
        boolean ok = false, back = false, front = false;
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
            if (a[i].equals(x)) ok = true;
            if (a[i].charAt(1) == x.charAt(0)) front = true;
            if (a[i].charAt(0) == x.charAt(1)) back = true;
        }
        ok |= (front && back);
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
        try (BarkToUnlock instance = new BarkToUnlock()) {
            instance.solve();
        }
    }
}
