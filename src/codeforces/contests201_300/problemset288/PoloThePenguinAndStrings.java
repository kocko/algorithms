package codeforces.contests201_300.problemset288;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PoloThePenguinAndStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        if (k > n) {
            out.println(-1);
            return;
        }
        int next = 0;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = findNext(next);
            next ^= 1;
        }
        for (int i = 0; i < k - 2; i++) {
            result[n - 1 - i] = (char) ('a' + k - i - 1);   
        }
        if (ok(result, k)) {
            for (char c : result) {
                out.print(c);
            }
        } else {
            out.println(-1);
        }
    }
    
    private boolean ok(char[] result, int k) {
        boolean[] used = new boolean[26];
        int count = 0;
        for (char c : result) {
            if (!used[c - 'a']) {
                used[c - 'a'] = true;
                count++;
            }
        }
        return count == k;
    }
    
    private char findNext(int idx) {
        return (char) ('a' + idx);
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
        try (PoloThePenguinAndStrings instance = new PoloThePenguinAndStrings()) {
            instance.solve();
        }
    }
}
