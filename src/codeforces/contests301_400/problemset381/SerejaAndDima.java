package codeforces.contests301_400.problemset381;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerejaAndDima implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int s = 0, d = 0;
        int left = 0, right = n - 1;
        boolean serejaTurn = true;
        while (left <= right) {
            if (serejaTurn) {
                if (x[left] > x[right]) {
                    s += x[left];
                    left++;
                } else if (x[right] > x[left]) {
                    s += x[right];
                    right--;
                } else {
                    s += x[left];
                    left++; right--;
                }
            } else {
                if (x[left] > x[right]) {
                    d += x[left];
                    left++;
                } else if (x[right] > x[left]) {
                    d += x[right];
                    right--;
                } else {
                    d += x[left];
                    left++; right--;
                }
            }
            serejaTurn = !serejaTurn;
        }
        out.println(s + " " + d);
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
        try (SerejaAndDima instance = new SerejaAndDima()) {
            instance.solve();
        }
    }
}
