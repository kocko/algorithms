package codeforces.contests201_300.problemset253;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class PhysicsPractical implements Closeable {

    private InputReader in;
    private PrintWriter out;

    private PhysicsPractical() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }
    
    public void solve() {
        int n = in.ni();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.ni());
        }
        Collections.sort(list);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = list.get(i);
            int b = i;
            int left = i, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int max = list.get(mid);
                if (2 * min >= max) {
                    b = max(b, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int size = b - i + 1;
            result = max(result, size);
        }
        out.println(n - result);
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
        try (PhysicsPractical instance = new PhysicsPractical()) {
            instance.solve();
        }
    }
}
