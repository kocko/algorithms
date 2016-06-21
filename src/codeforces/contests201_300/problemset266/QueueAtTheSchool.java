package codeforces.contests201_300.problemset266;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QueueAtTheSchool implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), t = in.ni();
        char[] x = in.next().toCharArray();
        while (t-- > 0) {
            for (int i = 0; i < n - 1;) {
                if (x[i] == 'B' && x[i + 1] == 'G') {
                    char c = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = c;
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        for (char c : x) {
            out.print(c);
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
        try (QueueAtTheSchool instance = new QueueAtTheSchool()) {
            instance.solve();
        }
    }
}
