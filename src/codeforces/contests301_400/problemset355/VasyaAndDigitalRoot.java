package codeforces.contests301_400.problemset355;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaAndDigitalRoot implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), d = in.ni(), total = 1;
        if (d == 0) {
            if (n == 1) {
                out.println(0);
            } else {
                out.println("No solution");
            }
            return;
        }
        int[] result = new int[n];
        result[0] = 1;
        while (total < d) {
            for (int i = 0; i < n; i++) {
                if (result[i] < 9) {
                    result[i]++;
                    total++;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
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
        try (VasyaAndDigitalRoot instance = new VasyaAndDigitalRoot()) {
            instance.solve();
        }
    }
}
