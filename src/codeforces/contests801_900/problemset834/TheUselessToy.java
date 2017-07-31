package codeforces.contests801_900.problemset834;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheUselessToy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char start = in.next().charAt(0), end = in.next().charAt(0);
        int n = in.ni() % 4;
        char x = start, y = start;
        for (int i = 0; i < n; i++) {
            x = rotateClockWise(x);
            y = rotateCounterClockWise(y);
        }
        if (x == end && y == end) {
            out.println("undefined");
        } else if (x == end) {
            out.println("cw");
        } else {
            out.println("ccw");
        }
    }
    
    private char rotateClockWise(char c) {
        if (c == '^') return '>';
        if (c == '>') return 'v';
        if (c == 'v') return '<';
        if (c == '<') return '^';
        return 0x0000;
    }

    private char rotateCounterClockWise(char c) {
        if (c == '^') return '<';
        if (c == '>') return '^';
        if (c == 'v') return '>';
        if (c == '<') return 'v';
        return 0x0000;
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
        try (TheUselessToy instance = new TheUselessToy()) {
            instance.solve();
        }
    }
}
