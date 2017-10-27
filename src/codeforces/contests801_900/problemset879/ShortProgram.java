package codeforces.contests801_900.problemset879;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShortProgram implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), low = 0, high = 1023;
        for (int i = 0; i < n; i++) {
            char op = in.next().charAt(0);
            int value = in.ni();
            if (op == '&') {
                low &= value;
                high &= value;
            } else if (op == '|') {
                low |= value;
                high |= value;
            } else {
                low ^= value;
                high ^= value;
            }
        }
        out.println(2);
        out.printf("& %d\n", (low ^ high));
        out.printf("^ %d\n", low);
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
        try (ShortProgram instance = new ShortProgram()) {
            instance.solve();
        }
    }
}
