package hackerrank.contests.weekofcode25;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AppendAndDelete implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String a = in.next(), b = in.next();
        if (a.equals(b)) {
            out.println("Yes");
            return;
        }
        char[] s = a.toCharArray(), t = b.toCharArray();
        int x = s.length, y = t.length;
        int k = in.ni();
        int result = 0;
        if (x > y) {
            result += x - y;
            x = y;
        }
        int index = -1;
        for (int i = 0; i < x; i++) {
            if (s[i] != t[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            result += (y - x);
            if (x + y <= k) {
                out.println("Yes");
                return;
            }
        } else {
            result += x - index;
            x -= (x - index);
            if (x == 0 && result + y <= k) {
                out.println("Yes");
                return;
            }
            result += y - x;
        }
        if (result <= k && (k - result) % 2 == 0) {
            out.println("Yes");
        } else {
            out.println("No");
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
        try (AppendAndDelete instance = new AppendAndDelete()) {
            instance.solve();
        }
    }
}
