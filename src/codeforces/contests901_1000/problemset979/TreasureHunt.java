package codeforces.contests901_1000.problemset979;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class TreasureHunt implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] words = new String[]{in.next(), in.next(), in.next()};
        int m = words[0].length();
        int max = 0, winner = -1;
        boolean draw = false;
        for (int i = 0; i < 3; i++) {
            int[] cnt = new int[52];
            char[] word = words[i].toCharArray();
            for (char c : word) {
                if (c >= 'a' && c <= 'z') cnt[c - 'a']++;
                else cnt[c - 'A' + 26]++;
            }
            int best = 0;
            for (int j = 0; j < 52; j++) {
                if (cnt[j] > best) {
                    best = cnt[j];
                }
            }
            int score;
            if (best == m && n == 1) {
                score = m - 1;
            } else {
                score = min(best + n, m);
            }
            if (score > max) {
                max = score;
                winner = i;
                draw = false;
            } else if (score == max) {
                draw = true;
            }
        }
        String[] names = {"Kuro", "Shiro", "Katie"};
        out.println(draw ? "Draw" : names[winner]);
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
        try (TreasureHunt instance = new TreasureHunt()) {
            instance.solve();
        }
    }
}
