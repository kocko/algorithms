package codeforces.contests801_900.problemset832;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PetyaAndExam implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        for (char c : in.next().toCharArray()) {
            good[c - 'a'] = true;
        }
        char[] pattern = in.next().toCharArray();
        StringBuilder leftBuilder = new StringBuilder(), rightBuilder = new StringBuilder();
        StringBuilder current = leftBuilder;
        for (char c : pattern) {
            if (c == '*') {
                hasStar = true;
                current = rightBuilder;
                continue;
            }
            current.append(c);
        }
        left = leftBuilder.toString();
        right = rightBuilder.toString();
        int q = in.ni();
        while (q-- > 0) {
            String word = in.next();
            out.println(matches(word) ? "YES" : "NO");
        }
    }

    private String left, right;
    private boolean hasStar;
    private boolean[] good = new boolean[26];

    private boolean matches(String word) {
        return word.length() >= left.length() + right.length() && 
                matchLeft(left, word) && 
                matchMiddle(word) && 
                matchRight(right, word);
    }

    private boolean matchLeft(String pattern, String word) {
        boolean result = true;
        if (pattern.length() == 0) {
            if (hasStar) {
                for (int i = 0; i < word.length() - right.length(); i++) {
                    result &= !good[word.charAt(i) - 'a'];
                }    
            } else {
                result = right.length() == word.length();
            }
            return result;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '?') {
                result &= good[word.charAt(i) - 'a'];
            } else {
                result &= c == word.charAt(i);
            }
        }
        return result;
    }
    
    private boolean matchMiddle(String word) {
        boolean result = true;
        for (int i = left.length(); i < word.length() - right.length(); i++) {
            result &= !good[word.charAt(i) - 'a'];
        }
        return result;
    }

    private boolean matchRight(String pattern, String word) {
        boolean result = true;
        if (pattern.length() == 0) {
            if (hasStar) {
                for (int i = left.length(); i < word.length(); i++) {
                    result &= !good[word.charAt(i) - 'a'];
                }    
            } else {
                result = left.length() == word.length();
            }
            return result;
        }
        int idx = word.length() - 1;
        for (int i = pattern.length() - 1; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (c == '?') {
                result &= good[word.charAt(idx) - 'a'];
            } else {
                result &= c == word.charAt(idx);
            }
            idx--;
        }
        return result;
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
        try (PetyaAndExam instance = new PetyaAndExam()) {
            instance.solve();
        }
    }
}
