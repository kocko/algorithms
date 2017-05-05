package codeforces.contests201_300.problemset298;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sail implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni(), a = in.ni(), b = in.ni(), c = in.ni(), d = in.ni();
        char[] x = in.next().toCharArray();
        int first = -1, second = -1;
        if (a <= c) {
            int current = a;
            if (current < c) {
                for (int i = 0; i < t; i++) {
                    if (x[i] == 'E') {
                        current++;
                    }
                    if (current == c) {
                        first = i + 1;
                        break;
                    }
                }
            } else {
                first = 0;
            }
        } else {
            int current = a;
            for (int i = 0; i < t; i++) {
                if (x[i] == 'W') {
                    current--;
                }
                if (current == c) {
                    first = i + 1;
                    break;
                }
            }
        }
        if (b <= d) {
            int current = b;
            if (current < d) {
                for (int i = 0; i < t; i++) {
                    if (x[i] == 'N') {
                        current++;
                    }
                    if (current == d) {
                        second = i + 1;
                        break;
                    }
                }
            } else {
                second = 0;
            }
        } else {
            int current = b;
            for (int i = 0; i < t; i++) {
                if (x[i] == 'S') {
                    current--;
                }
                if (current == d) {
                    second = i + 1;
                    break;
                }
            }
        }
        boolean ok = (first != -1 && second != -1);
        out.println(ok ? Math.max(first, second) : -1);
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
        try (Sail instance = new Sail()) {
            instance.solve();
        }
    }
}
