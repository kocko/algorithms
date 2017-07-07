package codeforces.contests301_400.problemset387;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GeorgeAndSleep implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] s = in.next().split(":"), t = in.next().split(":");
        int hour = 0;
        int minute = Integer.parseInt(s[1]) - Integer.parseInt(t[1]);
        if (minute < 0) {
            minute += 60;
            hour--;
        }
        hour += Integer.parseInt(s[0]) - Integer.parseInt(t[0]);
        if (hour < 0) hour += 24;
        
        out.printf("%02d", hour);
        out.printf(":");
        out.printf("%02d", minute);
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
        try (GeorgeAndSleep instance = new GeorgeAndSleep()) {
            instance.solve();
        }
    }
}
