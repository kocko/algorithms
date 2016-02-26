package hackerearth.dp;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberOfRs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            String word = in.next();
            out.println(kadane(word));
        }
    }

    int kadane(String word) {
        int n = word.length();
        int[] prefix = new int[n];
        int maxEndingHere = 0, maxSoFar = 0;
        char[] letters = word.toCharArray();
        int temp, start = 0, end = -1, bestStart = start, bestEnd = end;
        for (int i = 0; i < n; i++) {
            if (letters[i] == 'R') {
                if (i == 0) prefix[i] = 1;
                else prefix[i] = prefix[i - 1] + 1;
                temp = -1;
            } else {
                if (i == 0) prefix[i] = 0;
                else prefix[i] = prefix[i - 1];
                temp = 1;
            }

            maxEndingHere += temp;
            if (maxEndingHere < 0) {
                if (i < n - 1) start = i + 1; else start = i;
                maxEndingHere = 0;
            } else if (letters[i] == 'K') {
                end = i;
            }

            if (maxSoFar < maxEndingHere) {
                bestEnd = end;
                bestStart = start;
            }

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        if (bestEnd == -1) return n - 1;
        int result = 0;
        if (bestStart > 0) result += prefix[bestStart - 1];
        if (bestEnd < n - 1) result += prefix[n - 1] - prefix[bestEnd];
        result += (bestEnd - bestStart + 1) - (prefix[bestEnd] - prefix[bestStart]);
        return result;
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
        new NumberOfRs().solve();
    }
}
