package codeforces.gyms.acm;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Complexity implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        String s = in.next();
        boolean[] used = new boolean[26];
        int[] count = new int[26];
        int complexity = 0;
        for (char c : s.toCharArray()) {
            if (!used[c - 'a']) {
                complexity++;
                used[c - 'a'] = true;
            }
            count[c - 'a']++;
        }
        if (complexity > 2) {
            int result = 0;
            Arrays.sort(count);
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    result += count[i];
                    complexity--;
                }
                if (complexity <= 2) break;
            }
            out.println(result);
        } else {
            out.println(0);
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

    public static void main(String[] args) {
        new Complexity().solve();
    }
}
