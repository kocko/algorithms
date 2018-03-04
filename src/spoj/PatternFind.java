package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.String.valueOf;

public class PatternFind implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            char[] text = in.next().toCharArray(), pattern = in.next().toCharArray();
            int n = text.length, m = pattern.length;
            int[] fail = new int[m];
            for (int i = 1; i < m; i++) {
                fail[i] = fail[i - 1];
                while (fail[i] > 0 && pattern[i] != pattern[fail[i]]) {
                    fail[i] = fail[fail[i] - 1];
                }
                if (pattern[i] == pattern[fail[i]]) {
                    fail[i]++;
                }
            }
            StringJoiner result = new StringJoiner(" ");
            int start = 0, match = 0, count = 0;
            while (start + m <= n) {
                while (match < m && pattern[match] == text[start + match]) {
                    match++;
                }
                if (match == m) {
                    result.add(valueOf(start + 1));
                    count++;
                }
                match = max(0, match - 1);
                start += match - fail[match] + 1;
                match = fail[match];
            }
            if (count == 0) {
                out.println("Not Found");
            } else {
                out.println(count);
                out.println(result.toString());
            }
            if (t >= 1) {
                out.println();
            }
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
        try (PatternFind instance = new PatternFind()) {
            instance.solve();
        }
    }
}
