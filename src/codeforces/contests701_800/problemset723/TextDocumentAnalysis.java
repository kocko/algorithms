package codeforces.contests701_800.problemset723;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TextDocumentAnalysis implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        in.ni();
        char[] line = in.next().toCharArray();
        int outside = 0, inside = 0;
        int current = 0;
        boolean isInside = false;
        for (char c : line) {
            if (isLetter(c)) {
                current++;
            } else if (c == '(') {
                outside = Math.max(outside, current);
                current = 0;
                isInside = true;
            } else if (c == ')') {
                if (current > 0) {
                    inside++;
                }
                current = 0;
                isInside = false;
            } else if (c == '_') {
                if (isInside) {
                    if (current > 0) {
                        inside++;
                    }
                    current = 0;
                } else {
                    outside = Math.max(outside, current);
                    current = 0;
                }
            }
        }
        if (current > 0) {
            outside = Math.max(outside, current);
        }
        out.println(outside + " " + inside);
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
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
        try (TextDocumentAnalysis instance = new TextDocumentAnalysis()) {
            instance.solve();
        }
    }
}
