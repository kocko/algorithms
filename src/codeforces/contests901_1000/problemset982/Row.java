package codeforces.contests901_1000.problemset982;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Row implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        boolean valid = true;
        for (int j = 1; j < n; j++) {
            if (x[j] == '1' && x[j] == x[j - 1]) {
                valid = false;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (x[i] == '0') {
                x[i] = '1';
                boolean bad = false;
                for (int j = 1; j < n; j++) {
                    if (x[j] == '1' && x[j] == x[j - 1]) {
                        bad = true;
                    }
                }
                valid &= bad;
                x[i] = '0';
            }
        }
        out.println(valid ? "Yes" : "No");
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
        try (Row instance = new Row()) {
            instance.solve();
        }
    }
}
