package codeforces.contests101_200.problemset143;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpVasilisaTheWise2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int r1 = in.ni(), r2 = in.ni();
        int c1 = in.ni(), c2 = in.ni();
        int d1 = in.ni(), d2 = in.ni();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if (i != j && i != k && i != l && j != k && j != l && k != l) {
                            if (i + j == r1 && k + l == r2 && i + k == c1 && 
                                j + l == c2 && i + l == d1 && j + k == d2) {
                                out.println(i + " " + j);
                                out.println(k + " " + l);
                                return;
                            }
                        }
                    }
                }
            }
        }
        out.println(~0);
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
        try (HelpVasilisaTheWise2 instance = new HelpVasilisaTheWise2()) {
            instance.solve();
        }
    }
}
