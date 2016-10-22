package codeforces.contests701_800.problemset725;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HiddenWord implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private char[][] result = new char[2][13];
    
    public void solve() {
        String input = in.next();
        char[] x = input.toCharArray();
        char repeating = findRepeating(x);
        int start = -1, end = -1;
        for (int i = 0; i < 27; i++) {
            char c = x[i];
            if (c == repeating && start == -1) {
                start = i;
            } else if (c == repeating) {
                end = i;
                break;
            }
        }
        int diff = end - start - 1;
        if (diff == 0) {
            out.println("Impossible");
        } else {
            result[0][12 - (diff / 2)] = repeating;
            String sub = input.substring(input.indexOf(repeating) + 1, input.lastIndexOf(repeating));

            int next = 12 - (diff / 2);
            place(sub, 0, next);

            String first = input.substring(0, input.indexOf(repeating));
            if (!"".equals(first)) {
                int row = 0;
                for (int i = 0; i < first.length(); i++) {
                    char c = first.charAt(first.length() - i - 1);
                    if (row == 0) {
                        next--;
                        if (next == -1) {
                            row = 1;
                            next = 0;
                        }
                    } else {
                        next++;
                        if (next == 13) {
                            row = 0;
                            next = 12;
                        }
                    }
                    result[row][next] = c;
                }
            } 
            String last = input.substring(input.lastIndexOf(repeating) + 1);
            if (!"".equals(last)) {
                int row = 1;
                next = -1;
                for (int k = 12; k >= 0; k--) {
                    if (result[1][k] == '\u0000') {
                        next = k + 1;
                        break;
                    }
                }
                for (int i = 0; i < last.length(); i++) {
                    char c = last.charAt(i);
                    if (row == 0) {
                        next++;
                        if (next == 13) {
                            row = 1;
                            next = 12;
                        }
                    } else {
                        next--;
                        if (next == -1) {
                            row = 0;
                            next = 0;
                        }
                    }
                    result[row][next] = c;
                }
            }
            out.println(new String(result[0]));
            out.println(new String(result[1]));
        }
    }
    
    private void place(String s, int row, int next) {
        for (char c : s.toCharArray()) {
            if (row == 0) {
                next++;
                if (next == 13) {
                    next = 12;
                    row = 1;
                }
            } else {
                next--;
                if (next == -1) {
                    row = 0;
                    next = 0;
                }
            }
            result[row][next] = c;
        }
    }
    
    private char findRepeating(char[] x) {
        int[] count = new int[26];
        Arrays.fill(count, 2);
        for (char c : x) {
            count[c - 'A']--;
            if (count[c - 'A'] == 0) {
                return c;
            }
        }
        return 0;
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
        try (HiddenWord instance = new HiddenWord()) {
            instance.solve();
        }
    }
}

//ABAZYCDEFGHIJKLMNOPQRSTUVWX
//ABCDEFGHIJKLMNOPQRSGTUVWXYZ