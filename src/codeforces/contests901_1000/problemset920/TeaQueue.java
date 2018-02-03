package codeforces.contests901_1000.problemset920;

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

import static java.util.Arrays.fill;

public class TeaQueue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Student {
        private int idx, left, right;

        private Student(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            int[] result = new int[n];
            fill(result, -1);
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Student(i, in.ni(), in.ni()));
            }
            int idx = 0;
            for (int s = 1; s <= 5000; s++) {
                if (idx == n) break;
                while (idx < n && list.get(idx).right < s) {
                    result[idx] = 0;
                    idx++;
                }
                if (idx == n) break;
                if (list.get(idx).left <= s) {
                    result[idx++] = s;
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(result[i]);
                out.print(' ');
            }
            out.println();
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
        try (TeaQueue instance = new TeaQueue()) {
            instance.solve();
        }
    }
}
