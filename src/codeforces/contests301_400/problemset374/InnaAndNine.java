package codeforces.contests301_400.problemset374;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InnaAndNine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        List<Integer> sequences = new ArrayList<>();
        int current = 1, last = x[0] - '0', n = x.length;
        for (int i = 1; i < n; i++) {
            int value = x[i] - '0';
            if (last + value == 9) {
                current++;
            } else {
                sequences.add(current);
                current = 1;
            }
            last = value;
        }
        sequences.add(current);
        long result = 1L;
        for (int value : sequences) {
            result *= f(value);
        }
        out.println(result);
    }
    
    private long f(int x) {
        if (x % 2 == 0) return 1;
        return (x + 1) / 2;
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
        try (InnaAndNine instance = new InnaAndNine()) {
            instance.solve();
        }
    }
}
