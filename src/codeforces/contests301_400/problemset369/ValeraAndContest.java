package codeforces.contests301_400.problemset369;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ValeraAndContest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), min = in.ni(), max = in.ni(), all = in.ni(), top = in.ni();
        int[] a = new int[n];
        int bestGroupMinimum = top / k, rem = top % k, minTop = bestGroupMinimum;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                a[i] = bestGroupMinimum;
            } else {
                a[i] = min;
            }
            all -= a[i];
        }
        int idx = 0;
        while (rem > 0) {
            int possible = max - a[idx];
            int pile = min(possible, rem);
            a[idx] += pile;
            rem -= pile;
            all -= pile;
            minTop = min(a[idx], minTop);
            idx++;
        }
        idx = k;
        while (all > 0) {
            int possible = minTop - a[idx];
            int pile = min(possible, all);
            a[idx] += pile;
            all -= pile;
            idx++;
        }
        for (int s : a) {
            out.print(s);
            out.print(' ');
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
        try (ValeraAndContest instance = new ValeraAndContest()) {
            instance.solve();
        }
    }
}
