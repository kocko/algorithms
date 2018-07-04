package codeforces.contests1001_1100.problemset1003;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CoinsAndQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        int[] count = new int[31];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            int idx = -1;
            while (next > 0) {
                idx++;
                next >>= 1;
            }
            count[idx]++;
        }
        while (q-- > 0) {
            int next = in.ni();
            int result = 0;
            for (int i = 30; i >= 0; i--) {
                int current = 1 << i;
                int need = next / current;
                int temp = min(need, count[i]);
                result += temp;
                next -= temp * current; 
            }
            out.println(next == 0 ? result : -1);
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
        try (CoinsAndQueries instance = new CoinsAndQueries()) {
            instance.solve();
        }
    }
}
