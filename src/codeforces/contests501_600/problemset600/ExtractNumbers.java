package codeforces.contests501_600.problemset600;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExtractNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        String word = in.next() + ",!";
        String[] pieces = word.split("[;,]");
        StringBuilder numbers = new StringBuilder("\"");
        StringBuilder words = new StringBuilder("\"");

        for (int i = 0; i < pieces.length - 1; i++) {
            String piece = pieces[i];
            if (isNumber(piece)) {
                numbers.append(piece);
                numbers.append(",");
            } else {
                words.append(piece);
                words.append(",");
            }
        }
        numbers.setCharAt(numbers.length() - 1, '\"');
        words.setCharAt(words.length() - 1, '\"');
        if (numbers.length() == 1) numbers.setCharAt(0, '-');
        if (words.length() == 1) words.setCharAt(0, '-');

        out.println(numbers);
        out.println(words);
    }

    private boolean isNumber(String word) {
        if (word.length() == 0) return false;
        if (word.length() != 1) {
            for (int i = 0; i < word.length(); i++) {
                if (i == 0 && (word.charAt(i) < '1' || word.charAt(i) > '9')) {
                    return false;
                } else if (!Character.isDigit(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return Character.isDigit(word.charAt(0));
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

    public static void main(String[] args) {
        new ExtractNumbers().solve();
    }
}
