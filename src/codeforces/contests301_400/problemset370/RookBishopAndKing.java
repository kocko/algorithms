package codeforces.contests301_400.problemset370;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RookBishopAndKing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int r1 = in.ni(), c1 = in.ni(), r2 = in.ni(), c2 = in.ni();

        int rook = 1 + ((r1 != r2 && c1 != c2) ? 1 : 0);
        int king = Math.max(Math.abs(r2 - r1), Math.abs(c2 - c1));
        int bishop = 0;
        if ((r1 + c1) % 2 == (r2 + c2) % 2) {
            if (r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2) bishop = 1;
            else bishop = 2;
        }
        out.println(rook + " " + bishop + " " + king);
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
        try (RookBishopAndKing instance = new RookBishopAndKing()) {
            instance.solve();
        }
    }
}
