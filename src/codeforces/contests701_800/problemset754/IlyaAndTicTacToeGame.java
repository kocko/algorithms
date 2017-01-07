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
        char[][] x = new char[4][4];
        for (int i = 0; i < 4; i++) {
            x[i] = in.next().toCharArray();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x[i][j] == '.') {
                    x[i][j] = 'x';
                    if (valid(x)) {
                        out.println("YES");
                        return;
                    }
                    x[i][j] = '.';
                }
            }
        }
        out.println("NO");
    }

    private boolean valid(char[][] x) {
        for (int i = 0; i < 4; i++) {
            String next = new String(x[i]);
            if (ok(next)) {
                return true;
            }
        }
        for (int i = 0; i < 4; i++) {
            String next = "";
            for (int j = 0; j < 4; j++) {
                next += x[j][i];
            }
            if (ok(next)) {
                return true;
            }
        }
        String main = "", secondary = "";
        for (int i = 0; i < 4; i++) {
            main += x[i][i];
            secondary += x[i][3 - i];
        }
        if (ok(main) || ok(secondary)) {
            return true;
        }
        String p = String.valueOf(new char[]{x[0][1], x[1][2], x[2][3]});
        String q = String.valueOf(new char[]{x[1][0], x[2][1], x[3][2]});
        String r = String.valueOf(new char[]{x[0][2], x[1][1], x[2][0]});
        String t = String.valueOf(new char[]{x[1][3], x[2][2], x[3][1]});

        return "xxx".equals(p) || "xxx".equals(q) || "xxx".equals(r) || "xxx".equals(t);
    }

    private boolean ok(String x) {
        return x.substring(0, 3).equals("xxx") || x.substring(1, 4).equals("xxx");
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
