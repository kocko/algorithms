package codeforces.contests501_600.problemset519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AAndBAndChess implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int[] score = new int[26];
        score['q' - 'a'] = 9;
        score['r' - 'a'] = 5;
        score['b' - 'a'] = 3;
        score['n' - 'a'] = 3;
        score['p' - 'a'] = 1;
        int white = 0, black = 0;
        for (int i = 0; i < 8; i++) {
            char[] row = in.next().toCharArray();
            for (int j = 0; j < 8; j++) {
                char next = row[j];
                if (next != '.') {
                    if (Character.isUpperCase(next)) {
                        white += score[next - 'A'];
                    } else {
                        black += score[next - 'a'];
                    }
                }
            }
        }
        if (white == black) {
            out.println("Draw");
        } else if (white > black) {
            out.println("White");
        } else {
            out.println("Black");
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

    public static void main(String[] args) {
        new AAndBAndChess().solve();
    }
}
