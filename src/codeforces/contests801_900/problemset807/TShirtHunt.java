package codeforces.contests801_900.problemset807;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TShirtHunt implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int p = in.ni(), x = in.ni(), y = in.ni();
        int down = (int) 1e6;
        for (int s = x; s >= y; s -= 50) {
            if (can(s, p)) {
                down = 0;
                break;
            }
        }
        int up;
        for (int s = x; ; s += 50) {
            if (can(s, p)) {
                up = (s - x) / 100 + ((s - x) % 100 == 50 ? 1 : 0);
                break;
            }
        }
        out.println(Math.min(up, down));
    }
    
    private boolean can(int s, int p) {
        int i = (s / 50) % 475;
        for (int j = 0; j < 25; j++) {
            i = (i * 96 + 42) % 475;
            if (26 + i == p) return true;
        }
        return false;
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
        try (TShirtHunt instance = new TShirtHunt()) {
            instance.solve();
        }
    }
}
