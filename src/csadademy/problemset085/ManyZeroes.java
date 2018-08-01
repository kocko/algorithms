package csadademy.problemset085;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ManyZeroes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        char[] n = new char[s.length() + 1];
        n[0] = '0';
        for (int i = 1; i <= s.length(); i++) {
            n[i] = s.charAt(i - 1);
        }
        int max = in.ni(), y = 0, zeroes = 0;
        int idx = n.length - 1, carry;
        while (n[idx] == '0') {
            idx--;
            zeroes++;
        }
        int need = 10 - (n[idx] - '0');
        if (need <= max) {
            y += need;
            zeroes++;
            idx--;
        }

        while (n[idx] == '9') {
            n[idx--] = '0';
            zeroes++;
        }
        n[idx]++;


        while (y <= max) {
            int digit;
            if (idx >= 0) {
                digit = 10 - (n[idx] - '0');
            } else {
                digit = 9;
            }

            if (y + digit > max) break;
            else {
                zeroes++;
                y += digit;
                int i = idx - 1;
                while (i >= 0 && n[i] == '9') {
                    n[i] = '0';
                    zeroes++;
                    i--;
                }
                if (i >= 0) n[i]++;
            }
            idx--;
        }
        out.println(zeroes);
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
        try (ManyZeroes instance = new ManyZeroes()) {
            instance.solve();
        }
    }
}
