package codeforces.contests201_300.problemset219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni();
        char[] x = in.next().toCharArray();
        int[] cnt = new int[26];
        for (char c : x) {
            cnt[c - 'a']++;
        }
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                if (cnt[i] % k == 0) {
                    int times = cnt[i] / k;
                    for (int j = 0; j < times; j++) {
                        string.append((char) ('a' + i));
                    }
                } else {
                    out.println(-1);
                    return;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(string);
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

    public static void main(String[] args) throws IOException {
        try (KString instance = new KString()) {
            instance.solve();
        }
    }
}
