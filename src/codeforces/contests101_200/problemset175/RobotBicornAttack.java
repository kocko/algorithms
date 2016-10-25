package codeforces.contests101_200.problemset175;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RobotBicornAttack implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        int n = s.length();
        if (n < 3 || n > 21) {
            out.println(-1);
            return;
        }
        int max = -1;
        final int limit = (int) 1e6;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);
                if (valid(a) && valid(b) && valid(c)) {
                    Integer x = Integer.parseInt(a);
                    Integer y = Integer.parseInt(b);
                    Integer z = Integer.parseInt(c);
                    if (x <= limit && y <= limit && z <= limit) {
                        max = Math.max(max, Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c));
                    }
                }
            }
        }
        out.println(max);
    }
    
    private boolean valid(String s) {
        return (s.length() <= 7) && ((s.length() >= 2 && !s.startsWith("0")) | (s.length() == 1));
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
        try (RobotBicornAttack instance = new RobotBicornAttack()) {
            instance.solve();
        }
    }
}
