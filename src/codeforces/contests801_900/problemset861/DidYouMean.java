package codeforces.contests801_900.problemset861;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DidYouMean implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder(), consonants = new StringBuilder();
        for (char ch : x) {
            if (isVowel(ch)) {
                current.append(consonants);
                consonants = new StringBuilder();
                current.append(ch);
            } else {
                if (consonants.length() >= 2) {
                    boolean allAreSame = true;
                    for (int i = 0; i < consonants.length(); i++) {
                        allAreSame &= consonants.charAt(i) == ch;
                    }
                    if (allAreSame) {
                        consonants.append(ch);
                    } else {
                        current.append(consonants);
                        result.add(current.toString());
                        current = new StringBuilder();
                        consonants = new StringBuilder().append(ch);
                    }
                } else {
                    consonants.append(ch);
                }
            }
        }
        if (consonants.length() > 0) current.append(consonants);
        if (current.length() > 0) result.add(current.toString());
        for (String word : result) {
            out.print(word);
            out.print(' ');
        }
    }
    
    private boolean isVowel(char c) {
        return "aeoui".indexOf(c) != -1;
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
        try (DidYouMean instance = new DidYouMean()) {
            instance.solve();
        }
    }
}
