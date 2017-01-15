package codeforces.contests301_400.problemset353;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Domino implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int up = 0, down = 0;
        int swappable = 0;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if (x % 2 == 1) up ^= 1;
            if (y % 2 == 1) down ^= 1;
            if (x % 2 != y % 2) swappable++;
        }
        if (up != down) {
            out.println(-1);
        } else {
            if (up == 1 && swappable == 0) out.println(-1);
            else out.println(up);
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
        try (Domino instance = new Domino()) {
            instance.solve();
        }
    }
}
