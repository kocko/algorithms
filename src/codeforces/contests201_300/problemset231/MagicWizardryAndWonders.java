package codeforces.contests201_300.problemset231;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicWizardryAndWonders implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), d = in.ni(), l = in.ni();
        int odd, even;
        if (n % 2 == 0) {
            odd = even = n / 2;
        } else {
            even = (n + 1) / 2;
            odd = n - even;
        }
        int oddMax = odd * l, oddMin = odd;
        int evenMax = even * l, evenMin = even;
        Integer oddSum = null, evenSum = null;
        for (int a = evenMin; a <= evenMax; a++) {
            int b = a - d;
            if (b >= oddMin && b <= oddMax) {
                evenSum = a;
                oddSum = b;
                break;
            }
        }
        if (oddSum == null) {
            out.println(-1);
            return;
        }
        int k = evenSum / even, rem = evenSum % even;
        int[] result = new int[n];
        for (int i = 0; i < n; i += 2) {
            result[i] = k;
            if (i / 2 < rem) result[i]++;
        }
        int p = oddSum / odd;
        rem = oddSum % odd;
        for (int i = 1; i < n; i += 2) {
            result[i] = p;
            if (i / 2 < rem) result[i]++;
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
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
        try (MagicWizardryAndWonders instance = new MagicWizardryAndWonders()) {
            instance.solve();
        }
    }
}
