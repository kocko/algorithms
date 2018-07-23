package codeforces.contests1001_1100.problemset1006;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TwoStringsSwaps implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int result = 0;
        if (n % 2 == 1 && x[n / 2] != y[n / 2]) result++;
        for (int i = 0; i < n / 2; i++) {
            Set<Character> set = new HashSet<>();
            set.add(x[i]);
            set.add(y[i]);
            set.add(x[n - i - 1]);
            set.add(y[n - i - 1]);
            if (set.size() == 4) {
                result += 2;
            } else if (set.size() == 3) {
                if (x[i] == x[n - i - 1]) result += 2;
                else result++;
            } else if (set.size() == 2) {
                boolean t = ((x[i] == x[n - i - 1]) && (y[i] == y[n - i - 1])) ||
                            (x[i] == y[n - i - 1] && y[i] == x[n - i - 1]) ||
                            (x[i] == y[i] && x[n - i - 1] == y[n - i - 1]);
                if (!t) result++;
            }
        }
        out.println(result);
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
        try (TwoStringsSwaps instance = new TwoStringsSwaps()) {
            instance.solve();
        }
    }
}
