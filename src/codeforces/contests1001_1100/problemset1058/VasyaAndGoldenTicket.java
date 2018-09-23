package codeforces.contests1001_1100.problemset1058;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasyaAndGoldenTicket implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        boolean ok = false;
        out: for (int target = 0; target < 1000; target++) {
            int current = 0, count = 0;
            for (int i = 0; i < n; i++) {
                int value = x[i] - '0';
                if (current + value < target) {
                    current += value;
                } else if (current + value == target) {
                    count++;
                    current = 0;
                } else {
                    continue out;
                }
            }
            if ((current == 0 || current == target) && (count > 1)) {
                ok = true;
                break;
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (VasyaAndGoldenTicket instance = new VasyaAndGoldenTicket()) {
            instance.solve();
        }
    }
}
