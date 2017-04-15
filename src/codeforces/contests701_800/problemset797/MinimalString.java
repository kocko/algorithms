package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MinimalString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray();
        int n = s.length;
        int[] cnt = new int[26];
        for (char c : s) {
            cnt[c - 'a']++;
        }
        char[] result = new char[n];
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        for (char current : s) {
            char next = 'z' + 1;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    next = (char) ('a' + i);
                    break;
                }
            }
            while (!stack.isEmpty() && stack.peek() <= next) {
                result[idx++] = stack.pop();
            }
            if (current == next) {
                result[idx++] = current;
            } else {
                stack.add(current);
            }
            cnt[current - 'a']--;
        }
        while (!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }
        for (char c : result) {
            out.print(c);
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
        try (MinimalString instance = new MinimalString()) {
            instance.solve();
        }
    }
}
