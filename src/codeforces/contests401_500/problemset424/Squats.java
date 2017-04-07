package codeforces.contests401_500.problemset424;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Squats implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int up = 0, low = 0;
        for (char ch : x) {
            if (ch == 'X') up++;
            else low++;
        }
        int changes = (up - low) / 2;
        if (changes == 0) {
            out.println(0);
        } else if (up > low) {
            out.println(changes);
            for (int i = 0; i < n; i++) {
                if (up == low) break;
                if (x[i] == 'X') {
                    x[i] = 'x';
                    up--;
                    low++;
                }
            }
        } else {
            out.println(-changes);
            for (int i = 0; i < n; i++) {
                if (up == low) break;
                if (x[i] == 'x') {
                    x[i] = 'X';
                    low--;
                    up++;
                }
            }
        }
        out.println(new String(x));
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
        try (Squats instance = new Squats()) {
            instance.solve();
        }
    }
}
