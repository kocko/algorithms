package codeforces.contests101_200.problemset141;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AmusingJoke implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] used = new int[26];
        String first = in.next(), second = in.next(), third = in.next();
        for (char c : first.toCharArray()) {
            used[c - 'A']++;
        }
        for (char c : second.toCharArray()) {
            used[c - 'A']++;
        }
        boolean ok = true;
        for (char c : third.toCharArray()) {
            if (used[c - 'A'] == 0) {
                ok = false;
                break;
            }
            used[c - 'A']--;
        }
        if (ok) {
            for (int i : used) {
                if (i > 0) {
                    ok = false;
                    break;
                }
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (AmusingJoke instance = new AmusingJoke()) {
            instance.solve();
        }
    }
}
