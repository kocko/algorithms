package codeforces.contests701_800.problemset771;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndDifferentNames implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out, true);

    public void solve() {
        String[] names = generate();
        int n = in.ni(), k = in.ni();
        String[] result = new String[n];
        System.arraycopy(names, 0, result, 0, n);
        for (int i = 0; i < n - k + 1; i++) {
            boolean no = "NO".equals(in.next());
            if (no) {
                result[i + k - 1] = result[i];
            }
        }
        for (String name : result) {
            out.print(name);
            out.print(' ');
        }
    }

    private String[] generate() {
        String[] result = new String[50];
        char[] name = new char[2];
        for (int i = 0; i < 50; i++) {
            if (i < 26) name[0] = 'A';
            else name[0] = 'B';
            name[1] = (char) ('a' + i % 26);
            result[i] = new String(name);
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
        try (BearAndDifferentNames instance = new BearAndDifferentNames()) { instance.solve(); };
    }
}
