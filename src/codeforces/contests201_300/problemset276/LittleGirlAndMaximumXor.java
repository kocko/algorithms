package codeforces.contests201_300.problemset276;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleGirlAndMaximumXor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long l = in.nl(), r = in.nl();
        String a = Long.toBinaryString(l), b = Long.toBinaryString(r);
        if (b.length() > a.length()) {
            long bit = highestBit(r);
            out.println((bit << 1) - 1);
        } else {
            char[] result = new char[a.length()];
            int idx = 0;
            while (idx < a.length() && a.charAt(idx) == b.charAt(idx)) {
                result[idx++] = '0';
            }
            for (; idx < a.length(); idx++) {
                result[idx] = '1';
            }
            out.println(Long.valueOf(new String(result), 2));
        }
    }

    private long highestBit(long x) {
        long result = 0;
        while (x > 0) {
            result = (x & -x);
            x -= (x & -x);
        }
        return result;
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
        try (LittleGirlAndMaximumXor instance = new LittleGirlAndMaximumXor()) {
            instance.solve();
        }
    }
}
