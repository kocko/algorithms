package codeforces.contests701_800.problemset760;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PetrAndACalendar implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int m = in.ni(), d = in.ni();
        int days = getDays(m) - (7 - d + 1);
        int result = 1 + (days / 7) + (days % 7 != 0 ? 1 : 0);
        out.println(result);
    }
    
    private int getDays(int m) {
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) return 31;
        else if (m == 2) return 28;
        return 30;
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
        try (PetrAndACalendar instance = new PetrAndACalendar()) {
            instance.solve();
        }
    }
}
