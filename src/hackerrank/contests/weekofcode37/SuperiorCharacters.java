package hackerrank.contests.weekofcode37;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.max;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SuperiorCharacters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            long[] freq = new long[26];
            long total = 0;
            for (int i = 0; i < 26; i++) {
                freq[i] = in.nl();
                total += freq[i];
            }
            long max = (total - 1) / 2;

            int smaller = 0;
            int idx = 0;
            while (smaller <= total - max && idx < freq.length) {
                smaller += freq[idx++];
            }

            long additional = max + smaller - total;
            smaller -= freq[idx - 1];

            long matchedSupCount = min(additional, max(smaller - 1, 0));
            out.println(max - (additional - matchedSupCount));
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
        try (SuperiorCharacters instance = new SuperiorCharacters()) {
            instance.solve();
        }
    }
}
