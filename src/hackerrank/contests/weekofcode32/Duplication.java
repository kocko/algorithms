package hackerrank.contests.weekofcode32;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Duplication implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        StringBuilder sb = new StringBuilder("0");
        while (sb.length() < 1000) {
            char[] next = new char[sb.length()];
            sb.getChars(0, sb.length(), next, 0);
            sb.append(getXor(next));
        }
        String string = sb.toString();
        int q = in.ni();
        while (q-- > 0) {
            out.println(string.charAt(in.ni()));
        }
    }
    
    private String getXor(char[] x) {
        int n = x.length, idx = 0;
        char[] result = new char[n];
        for (char c : x) {
            result[idx++] = (c == '1' ? '0' : '1');
        }
        return new String(result);
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
        try (Duplication instance = new Duplication()) {
            instance.solve();
        }
    }
}
