package codeforces.contests501_600.problemset519;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AAndBAndCompilationErrors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] list1 = new int[n];
        for (int i = 0; i < n; i++) {
            list1[i] = in.ni();
        }
        int[] list2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            list2[i] = in.ni();
        }
        int first = xor(list1, list2);
        int[] list3 = new int[n - 2];
        for (int i = 0; i < n - 2; i++) {
            list3[i] = in.ni();
        }
        int second = xor(list2, list3);
        out.println(first);
        out.println(second);
    }

    private int xor(int[] ... list) {
        int result = 0;
        for (int[] array : list) {
            for (int i : array) {
                result ^= i;
            }
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
        new AAndBAndCompilationErrors().solve();
    }
}
