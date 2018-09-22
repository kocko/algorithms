package codeforces.contests1001_1100.problemset1046;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;
import static java.lang.Math.*;

public class PalindromePairs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] x = in.next().toCharArray();
            int mask = 0;
            for (char c : x) {
                int pos = c - 'a';
                mask ^= (1 << pos);
            }
            map.put(mask, map.getOrDefault(mask, 0L) + 1);
        }
        long result = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            long cnt = entry.getValue();
            result += (cnt * (cnt - 1)) / 2;
            int mask = entry.getKey();
            int copy = mask;
            while (copy > 0) {
                int bit = copy & -copy;
                int need = mask ^ bit;
                result += map.getOrDefault(need, 0L) * cnt;
                copy -= bit;
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

    public static void main(String[] args) throws IOException {
        try (PalindromePairs instance = new PalindromePairs()) {
            instance.solve();
        }
    }
}
