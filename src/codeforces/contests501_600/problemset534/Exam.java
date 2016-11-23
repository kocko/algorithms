package codeforces.contests501_600.problemset534;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Exam implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 2) {
            out.println(1);
            out.println(1);
            return;
        } else if (n == 3) {
            out.println(2);
            out.println("1 3");
            return;
        } else if (n == 4) {
            out.println(4);
            out.println("3 1 4 2");
            return;
        }
        int[] list = new int[n];
        int index = 0;
        int s = 1;
        while (index <= n - 1) {
            list[index] = s++;
            index += 2;
        }
        index = 1;
        while (index <= n - 1) {
            list[index] = s++;
            index += 2;
        }
        out.println(n);
        for (int i = 0; i < n; i++) {
            out.print(list[i] + " ");
        }
        out.println();
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
        try (Exam instance = new Exam()) {
            instance.solve();
        }
    }
}
