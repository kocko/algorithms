package codeforces.contests801_900.problemset845;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class LubaAndTheTicket implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int result = 10;
        for (int i = 0; i < 1000000; i++) {
            char[] value = String.format("%06d", i).toCharArray();
            if (sum(value, 0) == sum(value, 3)) {
                int diff = diff(x, value);
                result = Math.min(result, diff);
            }
        }
        out.println(result);
    }
    
    private int sum(char[] x, int start) {
        int result = 0;
        for (int i = start; i < start + 3; i++) {
            result += (x[i] - '0');
        }
        return result;
    }
    
    private int diff(char[] a, char[] b) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (a[i] != b[i]) cnt++;
        }
        return cnt;
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
        try (LubaAndTheTicket instance = new LubaAndTheTicket()) {
            instance.solve();
        }
    }
}
