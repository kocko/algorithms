package codeforces.contests301_400.problemset335;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Banana implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = in.ni(), unique = 0;
        int[] cnt = new int[26];
        for (char c : x) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] == 1) unique++;
        }
        if (unique > n) {
            out.println(-1);
            return;
        }
        int lo = 1, hi = 1005, min = 1005;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int total = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    if (cnt[i] <= mid) total++;
                    else {
                        total += (cnt[i] / mid) + (cnt[i] % mid != 0 ? 1 : 0);
                    }
                }
            }
            if (total <= n) {
                min = Math.min(min, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        char[] result = new char[n];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                if (cnt[i] <= min) result[idx++] = (char) ('a' + i);
                else {
                    int times = (cnt[i] / min) + (cnt[i] % min != 0 ? 1 : 0);
                    for (int j = 0; j < times; j++) {
                        result[idx++] = (char) ('a' + i);
                    }
                }
            }
        }
        while (idx < n) {
            result[idx++] = 'a';
        }
        out.println(min);
        for (int i = 0; i < result.length; i++) {
            out.print(result[i]);
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
        try (Banana instance = new Banana()) {
            instance.solve();
        }
    }
}
