package codeforces.contests801_900.problemset893;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChessForThree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        boolean[] play = new boolean[4];
        play[1] = play[2] = true;
        for (int i = 0; i < n; i++) {
            int winner = in.ni(), spectator = 0;
            for (int j = 1; j <= 3; j++) {
                if (!play[j]) {
                    spectator = j;
                    break;
                }
            }
            if (!play[winner]) {
                out.println("NO");
                return;
            } else {
                play[1] = play[2] = play[3] = false;
                play[winner] = play[spectator] = true;
            }
        }
        out.println("YES");
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
        try (ChessForThree instance = new ChessForThree()) {
            instance.solve();
        }
    }
}
