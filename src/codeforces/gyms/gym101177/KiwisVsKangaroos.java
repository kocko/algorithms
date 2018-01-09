package codeforces.gyms.gym101177;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KiwisVsKangaroos implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] c = in.next().toLowerCase().toCharArray();
        int kangaroo = count("kangaroo".toCharArray(), c), kiwi = count("kiwibird".toCharArray(), c);
        if (kangaroo > kiwi) {
            out.println("Kangaroos");
        } else if (kangaroo == kiwi) {
            out.println("Feud continues");
        } else {
            out.println("Kiwis");
        }
    }
    
    private int count(char[] key, char[] word) {
        int result = 0;
        for (char x : word) {
            int a = 0;
            for (char y : key) {
                if (x == y) a++;
            }
            result += a;
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
        try (KiwisVsKangaroos instance = new KiwisVsKangaroos()) {
            instance.solve();
        }
    }
}
