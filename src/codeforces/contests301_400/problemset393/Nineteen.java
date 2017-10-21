package codeforces.contests301_400.problemset393;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Nineteen implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = 0, i = 0, e = 0, t = 0;
        for (char c : x) {
            if (c == 'n') n++;
            else if (c == 'i') i++;
            else if (c == 'e') e++;
            else if (c == 't') t++;
        }
        String word = "nineteen";
        int ans = 0;
        out: while (true) {
            int start = ans > 0 ? 1 : 0;
            for (int j = start; j < word.length(); j++) {
                char c = word.charAt(j);
                if (c == 'n') {
                    if (n > 0) n--;
                    else break out;
                } else if (c == 'i') {
                    if (i > 0) i--;
                    else break out;
                } else if (c == 'e') {
                    if (e > 0) e--;
                    else break out;
                } else if (c == 't') {
                    if (t > 0) t--;
                    else break out;
                }
            }
            ans++;
        }
        out.println(ans);
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
        try (Nineteen instance = new Nineteen()) {
            instance.solve();
        }
    }
}
