package codeforces.contests401_500.problemset474;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Keyboard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    private char[] keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./".toCharArray();

    public void solve() {
        String dir = in.next();
        String message = in.next();
        int d = 1, index = 0;
        if ("R".equals(dir)) d = -1;
        char[] result = new char[message.length()];
        for (char c : message.toCharArray()) {
            result[index++] = real(c, d);
        }
        out.println(new String(result));
    }

    char real(char x, int dir) {
        int start = (dir == -1) ? 1 : 0;
        int end = (dir == -1) ? keyboard.length : keyboard.length - 1;
        for (int i = start; i < end; i++) {
            if (keyboard[i] == x) return keyboard[i + dir];
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

    public static void main(String[] args) {
        new Keyboard().solve();
    }
}
