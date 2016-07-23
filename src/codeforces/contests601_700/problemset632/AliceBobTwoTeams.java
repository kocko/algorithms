package codeforces.contests601_700.problemset632;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AliceBobTwoTeams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] strength = new int[n];
        for (int i = 0; i < n; i++) {
            strength[i] = in.ni();
        }
        String teams = in.next();
        char[] reverse = new StringBuilder(teams).reverse().toString().toCharArray();
        out.println(Math.max(maximizeScore(strength, teams.toCharArray()), maximizeScore(reverse(strength), reverse)));
    }

    private int[] reverse(int[] x) {
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = x[x.length - i - 1];
        }
        return result;
    }

    private long maximizeScore(int[] strength, char[] split) {
        int n = strength.length;
        if (n == 1) return strength[0];
        long[] prefix = new long[n];
        prefix[0] = split[0] == 'B' ? strength[0] : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (split[i] == 'B' ? strength[i] : 0);
        }

        long last = 0, result = prefix[n - 1];
        for (int i = 0; i < n; i++) {
            last += (split[i] == 'A' ? strength[i] : 0);
            result = Math.max(result, last + (prefix[n - 1] - prefix[i]));
        }

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
        new AliceBobTwoTeams().solve();
    }
}
