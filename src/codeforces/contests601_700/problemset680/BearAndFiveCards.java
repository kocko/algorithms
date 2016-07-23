package codeforces.contests601_700.problemset680;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndFiveCards implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int sum = 0;
        int[] used = new int[101];
        for (int i = 0; i < 5; i++) {
            int next = in.ni();
            used[next]++;
            sum += next;
        }
        int result = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 1; i <= 100; i++) {
            if (used[i] == 2) {
                found = true;
                result = Math.min(result, sum - 2 * i);
            } else if (used[i] > 2) {
                found = true;
                result = Math.min(result, sum - i * 3);
            }
        }
        if (found) {
            out.println(result);
        } else {
            out.println(sum);
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
        new BearAndFiveCards().solve();
    }
}
