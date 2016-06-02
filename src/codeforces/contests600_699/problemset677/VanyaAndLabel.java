package codeforces.contests600_699.problemset677;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VanyaAndLabel implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        char[] pattern = new char[64];
        int next = 0;
        for (char i = '0'; i <= '9'; i++, next++) {
            pattern[next] = i;
        }
        for (char i = 'A'; i <= 'Z'; i++, next++) {
            pattern[next] = i;
        }
        for (char i = 'a'; i <= 'z'; i++, next++) {
            pattern[next] = i;
        }
        pattern[next++] = '-';
        pattern[next] = '_';
        long[] value = new long[1024];
        for (int i = 0; i < 64; i++) {
            value[pattern[i]] = i; 
        }
        long result = 1;
        char[] word = in.next().toCharArray();
        for (int i = 0; i < word.length; i++) {
            long x = value[word[i]];
            for (int j = 0; j < 6; j++) {
                if ((x & (1 << j)) == 0) {
                    result = (result * 3) % 1000000007;
                }
            }
        }
        out.println(result);
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
        new VanyaAndLabel().solve();
    }
}
