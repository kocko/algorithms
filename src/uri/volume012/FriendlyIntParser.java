package uri.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FriendlyIntParser implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            parse(in.nextLine());
        }
    }
    
    private void parse(String line) {
        char[] result = new char[50];
        int idx = 0;
        boolean hasLetters = false;
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                result[idx++] = c;
            } else if (c == 'l') {
                result[idx++] = '1';
            } else if (c == 'o' || c == 'O') {
                result[idx++] = '0';
            } else if (Character.isLetter(c)) {
                hasLetters = true;
            }
        }
        if (hasLetters) {
            out.println("error");
            return;
        }
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            f.append(result[i]);
        }
        try {
            long value = Long.parseLong(f.toString());
            if (value > Integer.MAX_VALUE) {
                out.println("error");
            } else {
                out.println(value);
            }
        } catch (NumberFormatException e) {
            out.println("error");
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

    public static void main(String[] args) throws IOException {
        try (FriendlyIntParser instance = new FriendlyIntParser()) {
            instance.solve();
        }
    }
}
