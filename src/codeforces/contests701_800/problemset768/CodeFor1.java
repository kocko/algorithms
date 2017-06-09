package codeforces.contests701_800.problemset768;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeFor1 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), left = in.nl(), right = in.nl();
        char[] binary = Long.toBinaryString(n).toCharArray();
        int result = 0;
        for (long i = left; i <= right; i++) {
            long bit = i & -i;
            result += (binary[log(bit) - 1] == '1' ? 1 : 0);
        }
        out.println(result);
    }
    
    private int log(long value) {
        int res = 0;
        while (value > 0) {
            value >>= 1;
            res++;
        }
        return res;
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
        try (CodeFor1 instance = new CodeFor1()) {
            instance.solve();
        }
    }
}
