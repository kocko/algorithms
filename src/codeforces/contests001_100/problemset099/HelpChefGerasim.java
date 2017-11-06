package codeforces.contests001_100.problemset099;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpChefGerasim implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int total = 0;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            total += x[i];
        }
        double average = ((double) total / n);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] != average) diff++;
        }
        if (diff == 0) {
            out.println("Exemplary pages.");
        } else if (diff > 0 && diff != 2) {
            out.println("Unrecoverable configuration.");
        } else if (diff == 2) {
            int from = 0, to = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] < average) from = i + 1;
                else if (x[i] > average) to = i + 1;
            }
            int t = (x[to - 1] - x[from - 1]);
            if (t % 2 == 1) {
                out.println("Unrecoverable configuration.");
            } else {
                out.printf("%d ml. from cup #%d to cup #%d.\n", t / 2, from, to);
            }
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
        try (HelpChefGerasim instance = new HelpChefGerasim()) {
            instance.solve();
        }
    }
}
