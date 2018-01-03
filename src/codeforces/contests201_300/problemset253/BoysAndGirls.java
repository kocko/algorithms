package codeforces.contests201_300.problemset253;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BoysAndGirls implements Closeable {

    private InputReader in;
    private PrintWriter out;

    private BoysAndGirls() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }

    public void solve() {
        int n = in.ni(), m = in.ni(), max = Math.max(n, m), min = Math.min(n, m);
        char maxLetter = 'B', minLetter = 'G';
        if (n < m) {
            maxLetter = 'G';
            minLetter = 'B';
        }
        char[] result = new char[201];
        int idx = 0;
        for (int i = 0; i < max; i++) {
            result[idx] = maxLetter;
            idx += 2;
        }
        idx = 1;
        for (int i = 0; i < min; i++) {
            result[idx] = minLetter;
            idx += 2;
        }
        for (int i = 0; i < 201; i++) {
            if (result[i] != 0x0000) {
                out.print(result[i]);
            }
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
        try (BoysAndGirls instance = new BoysAndGirls()) {
            instance.solve();
        }
    }
}
