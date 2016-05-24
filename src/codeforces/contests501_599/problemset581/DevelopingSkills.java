package codeforces.contests501_599.problemset581;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DevelopingSkills implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), k = in.ni();
        Integer[] list = new Integer[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            list[i] = next;
            total += (next / 10);
        }
        Arrays.sort(list, (o1, o2) -> Integer.compare(o2 % 10, o1 % 10));
        for (int i = 0; i < n; i++) {
            if (k <= 0) break;
            if (list[i] == 100) continue;
            int x = 10 - (list[i] % 10);
            if (x <= k) {
                list[i] += x;
                k -= x;
                total++;
            }
        }
        while (k >= 10 && total < n * 10) {
            for (int i = 0; i < n; i++) {
                if (k <= 0) break;
                if (list[i] < 100 && k >= 10) {
                    k -= 10;
                    list[i] += 10;
                    total++;
                }
            }
        }
        out.println(total);
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
        new DevelopingSkills().solve();
    }
}
