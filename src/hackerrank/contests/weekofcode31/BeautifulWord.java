package hackerrank.contests.weekofcode31;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulWord implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] word = in.next().toCharArray();
        boolean isBeautiful = !hasConsecutiveVowels(word) && !hasConsecutiveDuplicates(word);
        out.println(isBeautiful ? "Yes" : "No");
    }
    
    private boolean hasConsecutiveVowels(char[] word) {
        int n = word.length;
        for (int i = 1; i < n; i++) {
            if (isVowel(word[i - 1]) && isVowel(word[i])) return true;
        }
        return false;
    }
    
    private boolean isVowel(char c) {
        return "aeiouy".indexOf(c) != -1;
    }
    
    private boolean hasConsecutiveDuplicates(char[] word) {
        int n = word.length;
        for (int i = 1; i < n; i++) {
            if (word[i - 1] == word[i]) return true;
        }
        return false;
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
        try (BeautifulWord instance = new BeautifulWord()) {
            instance.solve();
        }
    }
}
