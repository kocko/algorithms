package codeforces.contests501_600.problemset556;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CaseOfFakeNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        boolean ok = false;
        int idx = 0;
        do {
            boolean stop = true;
            for (int i = 0; i < n; i++) {
                if (x[i] != i) {
                    stop = false;
                    break;
                }
            }
            if (!stop) {
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        x[i] = (x[i] + 1) % n;
                    } else {
                        x[i]--;
                        if (x[i] < 0) x[i] = n - 1;
                    }
                }
            } else {
                ok = true;
                break;
            }
        } while (++idx < 1000);
        out.println(ok ? "Yes" : "No");
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
        try (CaseOfFakeNumbers instance = new CaseOfFakeNumbers()) {
            instance.solve();
        }
    }
}
