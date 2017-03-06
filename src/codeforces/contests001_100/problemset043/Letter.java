package codeforces.contests001_100.problemset043;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Character.isUpperCase;

public class Letter implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] from = in.nextLine().toCharArray();
        int[] has = new int[52];
        for (char c : from) {
            if (c == 0x020) continue;
            if (isUpperCase(c)) {
                has[26 + c - 'A']++;
            } else {
                has[c - 'a']++;
            }
        }
        char[] to = in.nextLine().toCharArray();
        boolean ok = true;
        for (char c : to) {
            if (c == 0x020) continue;
            if (isUpperCase(c)) {
                ok &= has[c + 26 - 'A']-- > 0;
            } else  {
                ok &= has[c - 'a']-- > 0;
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
        try (Letter instance = new Letter()) {
            instance.solve();
        }
    }
}
