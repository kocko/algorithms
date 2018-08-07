package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;
import static java.lang.Math.*;

public class Unique implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String left = in.next(), right = in.next();
        if (left.length() <= 10) this.min = min(this.min, parseLong(left));
        if (right.length() <= 10) this.max = min(this.max, parseLong(right));
        recurse(0, 0);
        out.println(result);
    }

    private int result;
    private long min = 9876543210L, max = 9876543210L;
    
    private void recurse(long number, int mask) {
        if (number >= min && number <= max) result++;
        
        for (int i = 1; i <= 9; i++) {
            if ((mask & (1 << i)) == 0) {
                long next = number * 10 + i;
                if (next <= max) {
                    recurse(next, mask | (1 << i));
                }
            }
        }
        if ((mask & 1) == 0 && number > 0 && number * 10 <= max) {
            recurse(number * 10, mask | 1);
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
            return parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (Unique instance = new Unique()) {
            instance.solve();
        }
    }
}
