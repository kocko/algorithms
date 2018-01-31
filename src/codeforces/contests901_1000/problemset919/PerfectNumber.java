package codeforces.contests901_1000.problemset919;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class PerfectNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), count = 0;
        for (int i = 19; ; i++) {
            if (ok(i)) {
                count++;
                if (count == n) {
                    out.print(i);
                    return;
                }
            }
        }
    }
    
    private boolean ok(int i) {
        int c = 0;
        char[] a = String.valueOf(i).toCharArray();
        for (char x : a) {
            c += (x - '0');
        }
        return c == 10;
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
        try (PerfectNumber instance = new PerfectNumber()) {
            instance.solve();
        }
    }
}
