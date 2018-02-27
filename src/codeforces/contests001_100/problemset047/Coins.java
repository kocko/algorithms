package codeforces.contests001_100.problemset047;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Coins implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] deg = new int[3];
        for (int i = 0; i < 3; i++) {
            char[] x = in.next().toCharArray();
            int u = x[0] - 'A', v = x[2] - 'A';
            if (x[1] == '>') deg[v]++;
            else deg[u]++;
        }
        StringBuilder result = new StringBuilder();
        for (int d = 2; d >= 0; d--) {
            int idx = -1;
            for (int j = 0; j < 3; j++) {
                if (deg[j] == d) {
                    if (idx == -1) {
                        idx = j;
                    }  else {
                        out.println("Impossible");
                        return;
                    }
                }
            }
            if (idx != -1) {
                result.append((char) ('A' + idx));
            } else {
                out.println("Impossible");
                return;
            }
        }
        out.println(result.toString());
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
        try (Coins instance = new Coins()) {
            instance.solve();
        }
    }
}
