package codeforces.contests101_200.problemset106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CardGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char trump = in.next().charAt(0);
        char[] a = in.next().toCharArray(), b = in.next().toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('T', 10);
            put('J', 11);
            put('Q', 12);
            put('K', 13);
            put('A', 14);
        }};
        boolean wins;
        if (a[1] == b[1]) {
            wins = map.get(a[0]) > map.get(b[0]);
        } else {
            wins = a[1] == trump;
        }
        out.println(wins ? "YES" : "NO");
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
        try (CardGame instance = new CardGame()) {
            instance.solve();
        }
    }
}
