package codeforces.contests501_600.problemset544;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SeaAndIslands implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int max;
        if (n % 2 == 0) {
            max = (n * n) / 2;
        } else {
            max = ((n + 1) * (n + 1)) / 4 + (n / 2) * (n / 2);
        }
        if (k <= max) {
            out.println("YES");
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        if (j % 2 == 0 && count < k) {
                            out.print("L");
                            count++;
                        } else {
                            out.print("S");
                        }
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        if (j % 2 == 1 && count < k) {
                            out.print("L");
                            count++;
                        } else {
                            out.print("S");
                        }
                    }
                }
                out.println();
            }
        } else {
            out.println("NO");
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
        try (SeaAndIslands instance = new SeaAndIslands()) {
            instance.solve();
        }
    }
}
