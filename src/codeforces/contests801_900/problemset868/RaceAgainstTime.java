package codeforces.contests801_900.problemset868;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RaceAgainstTime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int h = in.ni(), m = in.ni(), s = in.ni(), t1 = in.ni(), t2 = in.ni();
        h %= 12;
        h = h * 3600 + m * 60 + s;
        m = 12 * (m * 60 + s);
        s *= 720;
        
        t1 %= 12; t1 *= 3600;
        t2 %= 12; t2 *= 3600;
        if (t1 < t2) t2 = (t1 + t2) - (t1 = t2);
        if (h <= t1 && h >= t2 && m <= t1 && m >= t2 && s <= t1 && s >= t2) {
            out.println("YES");
        } else if ((h >= t1 || h <= t2) && (m >= t1 || m <= t2) && (s >= t1 || s <= t2)) {
            out.println("YES");
        } else {
            out.println("NO");
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
        try (RaceAgainstTime instance = new RaceAgainstTime()) {
            instance.solve();
        }
    }
}
