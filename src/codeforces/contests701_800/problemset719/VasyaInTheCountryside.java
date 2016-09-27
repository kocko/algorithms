package codeforces.contests701_800.problemset719;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaInTheCountryside implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            int next = in.ni();
            if (next == 15) {
                out.println("DOWN");
            } else if (next == 0) {
                out.println("UP");
            } else {
                out.println(-1);
            }
        } else {
            int last = in.ni();
            boolean up = true;
            for (int i = 1; i < n; i++) {
                int next = in.ni();
                up = (next > last && next != 15) || (next == 0);
                last = next;
            }
            out.println(up ? "UP" : "DOWN");
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
        try (VasyaInTheCountryside instance = new VasyaInTheCountryside()) {
            instance.solve();
        }
    }
}
