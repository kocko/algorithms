package codeforces.contests401_500.problemset476;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DreamoonAndWiFi implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int ones = 0, zeroes = 0;
        for (char ch : x) {
            if (ch == '+') ones++;
            else zeroes++;
        }
        int unknown = 0;
        for (char ch : y) {
            if (ch == '?') unknown++;
            else {
                if (ch == '+') ones--;
                else zeroes--;
            }
        }
        if (unknown == 0) {
            if (ones == 0 && zeroes == 0) {
                out.println(1d);
            } else {
                out.println(0d);
            }
        } else {
            int possible = 1 << unknown;
            int ok = 0;
            for (int i = 0; i < possible; i++) {
                int bitcount = Integer.bitCount(i);
                int z = unknown - bitcount;
                if (ones - bitcount == 0 && zeroes - z == 0) ok++;
            }
            out.println(((double) ok) / possible);
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
        try (DreamoonAndWiFi instance = new DreamoonAndWiFi()) {
            instance.solve();
        }
    }
}
