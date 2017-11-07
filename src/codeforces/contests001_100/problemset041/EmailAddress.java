package codeforces.contests001_100.problemset041;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EmailAddress implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        x = x.replaceAll("at", "@").replaceAll("dot", ".");
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (i == 0 || i == x.length() - 1) {
                if (x.charAt(i) == '.') {
                    temp.append("dot");
                } else if (x.charAt(i) == '@') {
                    temp.append("at");
                } else {
                    temp.append(x.charAt(i));
                }
            } else {
                temp.append(x.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        int idx = -1;
        for (int i = 0; i < temp.length(); i++) {
            result.append(temp.charAt(i));
            if (temp.charAt(i) == '@') {
                idx = i;
                break;
            }
        }
        for (int i = idx + 1; i < temp.length(); i++) {
            if (temp.charAt(i) == '@') {
                result.append("at");
            } else {
                result.append(temp.charAt(i));
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
        try (EmailAddress instance = new EmailAddress()) {
            instance.solve();
        }
    }
}
