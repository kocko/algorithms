package codeforces.contests001_100.problemset048;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RockPaperScissors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        boolean f = false, m = false, s = false;
        String fyodor = in.next(), matroskin = in.next(), sharik = in.next();
        if (wins(fyodor, matroskin) && wins(fyodor, sharik)) f = true;
        if (wins(matroskin, fyodor) && wins(matroskin, sharik)) m = true;
        if (wins(sharik, fyodor) && wins(sharik, matroskin)) s = true;

        if (f && !s && !m) out.println('F');
        else if (!f && s && !m) out.println("S");
        else if (!f && !s && m) out.println("M");
        else out.println("?");
    }

    private boolean wins(String a, String b) {
        if (a.equals(b)) return false;
        if ("rock".equals(a)) return "scissors".equals(b);
        if ("scissors".equals(a)) return "paper".equals(b);
        if ("paper".equals(a)) return "rock".equals(b);
        return false;
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
        try (RockPaperScissors instance = new RockPaperScissors()) {
            instance.solve();
        }
    }
}
