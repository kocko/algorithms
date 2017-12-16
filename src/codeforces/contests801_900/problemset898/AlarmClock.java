package codeforces.contests801_900.problemset898;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.util.Comparator.naturalOrder;

public class AlarmClock implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni(), max = 1000001;
        boolean[] alarm = new boolean[max];
        for (int i = 0; i < n; i++) {
            alarm[in.ni()] = true;
        }
        int current = 0, result = 0;
        for (int i = 1; i < max; i++) {
            if (alarm[i]) {
                current++;
            }
            if (i > m && alarm[i - m]) {
                current--;
            }
            if (current == k) {
                result++;
                current--;
                alarm[i] = false;
            }
        }
        out.println(result);

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
        try (AlarmClock instance = new AlarmClock()) {
            instance.solve();
        }
    }
}
