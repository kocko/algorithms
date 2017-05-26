package codeforces.contests401_500.problemset475;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BayanBus implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[][] bus = {
                    "+------------------------+" .toCharArray(),
                    "|#.#.#.#.#.#.#.#.#.#.#.|D|)".toCharArray(),
                    "|#.#.#.#.#.#.#.#.#.#.#.|.|" .toCharArray(),
                    "|#.......................|" .toCharArray(),
                    "|#.#.#.#.#.#.#.#.#.#.#.|.|)".toCharArray(),
                    "+------------------------+" .toCharArray() };
        for (int j = 1; j <= 21; j += 2) {
            for (int i = 1; i <= 4; i++) {
                if (bus[i][j] == '#' && n > 0) {
                    bus[i][j] = 'O';
                    n--;
                }
            }
        }
        for (char[] c : bus) {
            for (char x : c) {
                out.print(x);
            }
            out.println();
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
        try (BayanBus instance = new BayanBus()) {
            instance.solve();
        }
    }
}
