package codeforces.contests701_800.problemset754;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IlyaAndTicTacToeGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] x = new String[4];
        for (int i = 0; i < 4; i++) {
            x[i] = in.next();
        }
        for (int i = 0; i < 4; i++) {
            String next = x[i];
            if (ok(next)) {
                out.println("YES"); return;
            }
        }
        for (int i = 0; i < 4; i++) {
            String next = "";
            for (int j = 0; j < 4; j++) {
                next += x[j].charAt(i);
            }
            if (ok(next)) {
                out.println("YES"); return;
            }
        }
        String main = "", secondary = "";
        for (int i = 0; i < 4; i++) {
            main += x[i].charAt(i);
            secondary += x[i].charAt(3 - i);
        }
        if (ok(main) || ok(secondary)) {
            out.println("YES"); return;
        }
        out.println("NO");
    }

    private boolean ok (String x) {
        return x.substring(0, 3).equals(".xx") ||
                x.substring(0, 3).equals("xx.") ||
                x.substring(0, 3).equals("x.x") ||
                x.substring(1, 4).equals(".xx") ||
                x.substring(1, 4).equals("xx.") ||
                x.substring(1, 4).equals("x.x");
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
        try (IlyaAndTicTacToeGame instance = new IlyaAndTicTacToeGame()) {
            instance.solve();
        }
    }
}
