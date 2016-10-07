package codeforces.contests101_200.problemset160;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnluckyTicket implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        in.nl();
        String ticket = in.next();
        int k = ticket.length() / 2;
        char[] a = new char[k];
        char[] b = new char[k];
        for (int i = 0; i < k; i++) {
            a[i] = ticket.charAt(i);
            b[i] = ticket.charAt(k + i);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        boolean m = true;
        for (int i = 0; i < k; i++) {
            m &= a[i] > b[i];
        }
        boolean n = true;
        for (int i = 0; i < k; i++) {
            n &= a[i] < b[i];
        }
        out.println((m || n) ? "YES" : "NO");
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
        try (UnluckyTicket instance = new UnluckyTicket()) {
            instance.solve();
        }
    }
}
