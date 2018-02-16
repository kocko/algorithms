package codeforces.contests901_1000.problemset938;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class WordCorrection implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        StringBuilder result = new StringBuilder();
        boolean prevVowel = false;
        for (char c : x) {
            if (!prevVowel) {
                result.append(c);
                prevVowel = isVowel(c);
            } else {
                if (!isVowel(c)) {
                    result.append(c);
                    prevVowel = false;
                }
            }
        }
        out.println(result.toString());
    }
    
    private boolean isVowel(char c) {
        return "aeoiu".indexOf(c) >= 0;
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
        try (WordCorrection instance = new WordCorrection()) {
            instance.solve();
        }
    }
}
