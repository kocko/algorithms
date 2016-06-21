package codeforces.contests401_500.problemset451;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SortTheArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int left = 0, right = n - 1;
        while (left < right && a[left] < a[left + 1]) {
            left++;
        }
        while (left < right && a[right] > a[right - 1]) {
            right--;
        }
        for (int i = left, j = right; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            sorted &= a[i - 1] < a[i];
        }
        if (sorted) {
            out.println("yes");
            out.println((left + 1) + " " + (right + 1));
        } else {
            out.println("no");
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
        try (SortTheArray instance = new SortTheArray()) {
            instance.solve();
        }
    }
}
