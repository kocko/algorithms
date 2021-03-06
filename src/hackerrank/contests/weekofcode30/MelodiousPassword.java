package hackerrank.contests.weekofcode30;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MelodiousPassword implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private char[][] letters = {{ 'a', 'e', 'o', 'u', 'i' }, { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' }};
    private int n;
    
    public void solve() {
        this.n = in.ni();
        recurse(0, new char[n], 0);
        recurse(0, new char[n], 1);
    }
    
    private void recurse(int idx, char[] word, int storage) {
        if (idx == n) {
            for (int i = 0; i < idx; i++) {
                out.print(word[i]);
            }
            out.println();
        } else {
            for (char c : letters[storage]) {
                word[idx] = c;
                recurse(idx + 1, word, storage ^ 1);
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
        try (MelodiousPassword instance = new MelodiousPassword()) {
            instance.solve();
        }
    }
}
