package hackerrank.contests.weekofcode26;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArmyGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        out.println(recurse(n, m));
    }
    
    private int recurse(int n, int m) {
        if (n * m <= 0) return 0;
        if (n == 1 && m == 1) {
            return 1;
        } else if (n == 1 || m == 1) {
            int max = Math.max(m, n);
            return max / 2 + (max & 1);
        } else {
            int max = Math.max(m, n);
            int min = Math.min(m, n);
            int dots = (min / 2) * (max / 2);
            boolean a = false;
            if (min % 2 != 0) {
                a = true;
                dots += recurse(max, 1);
            }
            boolean b = false;
            if (max % 2 != 0) {
                b = true;
                dots += recurse(min, 1);
            }
            if (a & b) dots--;
            return dots;
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
        try (ArmyGame instance = new ArmyGame()) {
            instance.solve();
        }
    }
}
