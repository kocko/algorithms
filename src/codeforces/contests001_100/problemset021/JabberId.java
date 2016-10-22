package codeforces.contests001_100.problemset021;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JabberId implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        String current = "";
        int index = 0;
        boolean valid = true;
        boolean resourceFound = false, usernameFound = false;
        while (index < n) {
            if (x[index] == '@') {
                valid &= validateUsername(current);
                usernameFound = true;
                current = "";
            } else if (x[index] == '/') {
                valid &= validateHostname(current);
                resourceFound = true;
                current = "";
            } else {
                current += x[index];
            }
            index++;
        }
        if (!usernameFound) {
            valid = false;
        } else if (resourceFound) {
            valid &= validateUsername(current);
        } else {
            valid &= validateHostname(current);
        }
        out.println(valid ? "YES" : "NO");
    }
    
    private boolean validateUsername(String username) {
        boolean valid = username != null && (username.length() >= 1 && username.length() <= 16);
        if (valid) {
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                if (!isLetter(c) && c != '_' && !isDigit(c)) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
    
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
    private boolean validateHostname(String hostname) {
        boolean valid = hostname != null && (hostname.length() >= 1 && hostname.length() <= 32);
        if (valid) {
            String[] split = hostname.split("\\.", -1);
            for (String s : split) {
                if (s == null || "".equals(s)) valid = false;
                else valid &= validateUsername(s);
            }
        }
        return valid;
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
        try (JabberId instance = new JabberId()) {
            instance.solve();
        }
    }
}
