package codeforces.contests1001_1100.problemset1042;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Vitamins implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int INF = 400000;
        int n = in.ni(), a = INF, b = INF, c = INF, ab = INF, bc = INF, ac = INF, abc = INF;
        boolean has_a = false, has_b = false, has_c = false;
        for (int i = 0; i < n; i++) {
            int price = in.ni();
            char[] x = in.next().toCharArray();
            Arrays.sort(x);
            String p = String.valueOf(x);
            switch (p) {
                case "A": {
                    a = min(a, price);
                    has_a = true;
                    break;
                }
                case "B": {
                    b = min(b, price);
                    has_b = true;
                    break;
                }
                case "C": {
                    c = min(c, price);
                    has_c = true;
                    break;
                }
                case "AB": {
                    ab = min(ab, price);
                    has_a = has_b = true;
                    break;
                }
                case "BC": {
                    bc = min(bc, price);
                    has_b = has_c = true;
                    break;
                }
                case "AC": {
                    ac = min(ac, price);
                    has_a = has_c = true;
                    break;
                }
                case "ABC": {
                    abc = min(abc, price);
                    has_a = has_b = has_c = true;
                    break;
                }
            }
        }

        if (!has_a || !has_b || !has_c) {
            out.println(-1);
        } else {
            int min = INF;
            min = min(min, min(a + b + c, min(a + bc, a + abc)));
            min = min(min, min(b + a + c, min(b + ac, b + abc)));
            min = min(min, min(c + a + b, min(c + ab, c + abc)));
            min = min(min, min(ab + c, min(min(ab + ac, ab + bc), ab + abc)));
            min = min(min, min(bc + a, min(min(bc + ac, bc + ab), bc + abc)));
            min = min(min, min(ac + b, min(min(ac + ab, ac + bc), ac + abc)));
            min = min(min, abc);
            out.println(min);
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
        try (Vitamins instance = new Vitamins()) {
            instance.solve();
        }
    }
}
