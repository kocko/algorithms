package codeforces.contests901_1000.problemset907;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Shockers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), extra = 0, possible = 26;
        boolean[] can = new boolean[26];
        for (int i = 0; i < 26; i++) {
            can[i] = true;
        }
        while (n-- > 0) {
            char type = in.next().charAt(0);
            if (type == '!') {
                char[] word = in.next().toCharArray();
                if (possible == 1) {
                    extra++;
                } else {
                    int count = 0;
                    char guess = 0x000;
                    for (char c : word) {
                        if (can[c - 'a']) {
                            count++;
                            guess = c;
                        }
                    }
                    if (count == 1) {
                        possible = 1;
                        for (int i = 0; i < 26; i++) {
                            can[i] = false;
                        }
                        can[guess - 'a'] = true;
                    } else {
                        for (int i = 0; i < 26; i++) {
                            if (can[i]) {
                                boolean ok = false;
                                for (char c : word) {
                                    if (c - 'a' == i) {
                                        ok = true;
                                    }
                                }
                                if (!ok) {
                                    possible--;
                                    can[i] = false;
                                }
                            }
                        }
                    }
                }
            } else if (type == '.') {
                char[] word = in.next().toCharArray();
                for (char c : word) {
                    if (can[c - 'a']) {
                        possible--;
                        can[c - 'a'] = false;
                    }
                }
            } else {
                char guess = in.next().charAt(0);
                if (n > 0) {
                    if (possible == 1) {
                        extra++;
                    } else {
                        if (can[guess - 'a']) {
                            can[guess - 'a'] = false;
                            possible--;
                        }
                    }
                }
            }
        }
        out.println(extra);
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
        try (Shockers instance = new Shockers()) {
            instance.solve();
        }
    }
}
